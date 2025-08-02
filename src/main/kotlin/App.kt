import kotlin.math.pow

fun main(){
//    Step 1 Define Products (Arrays/Lists)
        val productNames = listOf("Laptop", "Mouse", "Keyboard", "Monitor", "Webcam")
        val productPrices = listOf(999.99,25.50,45.40,189.99,49.99)
        val invalidProduct = mutableListOf<String>()


//    Step 2 Display Products (Loops)

        var index = 0;
        for (name in productNames){
            println("${index+1}. $name $${productPrices[index]}")
            index++
        }

//    Step 3 Simulate Shopping Cart (MutableList)
       val shoppingCart = mutableListOf<String>()


       input@ while (true) {
           println("")
           print("Enter the product name:")
           val productName = readLine()!!.trim()
           var found = false;

           if (productName.lowercase().equals("Done".lowercase())) {
               println("===Your Shopping Cart Here===")
               println("=> Shopping cart: $shoppingCart")
               break;
           }


            //loop to find item
            for (product in productNames){
               if (productName.lowercase().equals(product.lowercase())){
                   shoppingCart.add(product)
                   println("................")
                   print("Added $product")
                   print("=> Your Cart Update: ")
                   print(shoppingCart)
                   found = true
                   break
               }




           }

            if (!found){
                println("................")
               println("Products ${productName} not match")
               invalidProduct.add(productName)

           }



       }

//    Step 4 Calculate Order Total (Loops & Conditions)
        var totalCost = 0.0
        var price = 0.0
        var foundItem = false
        for (itemName  in productNames){
            for (item in shoppingCart){
                if (item.lowercase().equals(itemName.lowercase())){

//                    find index of each product that contain in shopping cart
                    var indexProductName = productNames.indexOf(item)
//                    find product price based the index that found
                    price = productPrices[indexProductName]
                    totalCost += price
                    foundItem = true
                }
            }
        }
        if(foundItem){
            println("=> Total cost: $${totalCost}")
        }
        if (foundItem){
            if (invalidProduct.isEmpty()){
                println("")
            }else{
                println("................")
                println("Warning: Product '${invalidProduct}' not found in catalog.")
            }
        }

    //    Step 5 Apply Discount (Conditional—if-else or when)
    // countMouse
     var count = 0
     if (shoppingCart.any { it.equals("laptop", ignoreCase = true) } && shoppingCart.any { it.equals("mouse", ignoreCase = true) }){

         for (item in shoppingCart){
             if (item.lowercase().equals("mouse", ignoreCase = true)){
                 count += 1
             }
         }
//         find index of mouse
         var mouseIndex = productNames.indexOf("Mouse");
//         find mouse price
         var mousePrice = productPrices[mouseIndex]
//         find final price of mouse
         var totalMouse = mousePrice * count
//         8% of total mouse
         var discount =  totalMouse * 0.08
//         discount with final cost
          var finalCost = totalCost - discount
         println("======= Total after discount =======")
         println("=> Total cost $$finalCost")

     }else{
         println("No discount")
     }








}