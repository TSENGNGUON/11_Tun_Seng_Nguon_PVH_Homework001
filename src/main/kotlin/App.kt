import kotlin.math.pow

fun main(){
//    Step 1 Define Products (Arrays/Lists)
        val productNames = listOf("Laptop", "Mouse", "Keyboard", "Monitor", "Webcam","Wireless Charger","USB Hub","Headphones","External Hard Drive","Smartphone","Tablet","Bluetooth Speaker","Printer","Graphics Card","Desk Lamp","Office Chair","Microphone")
        val productPrices = listOf(999.99,25.50,45.40,189.99,49.99,29.99,15.00,89.99,79.50,699.99,399.99,59.99,149.99,349.99,24.99,129.99,25.99)
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
      var isBothCombo = false

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
            println("=> Total cost: $${"%.2f".format(totalCost)}")
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
//    Laptop + Mouse Combo
     var count = 0
     var flatDiscount = 10.00
     var finalCost = 0.0
     var laptopMouseDis =0.0
     var headPhoneMicrophoneDis = 0.0
     var isDiscount = false
    var discount =0.0
    if (shoppingCart.any { it.equals("laptop", ignoreCase = true) } && shoppingCart.any { it.equals("mouse", ignoreCase = true) }){
        isDiscount = true

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
         discount =  totalMouse * 0.08
//         discount with final cost
        laptopMouseDis  = totalCost - discount
        finalCost = laptopMouseDis




    }
    //    Headphones + Microphone Combo
    if (shoppingCart.any {it.equals("Headphones", ignoreCase = true) } && shoppingCart.any { it.equals("Microphone", ignoreCase = true) }){
        isDiscount = true
        headPhoneMicrophoneDis = totalCost - flatDiscount
        finalCost = headPhoneMicrophoneDis


    }
    // both combo
    if (shoppingCart.any {it.equals("Laptop", ignoreCase = true) } && shoppingCart.any { it.equals("Mouse", ignoreCase = true) && shoppingCart.any { it.equals("Headphones", ignoreCase = true) && shoppingCart.any { it.equals("Microphone", ignoreCase = true)} } }) {
        isDiscount = true
        var finalCombo = discount + flatDiscount
        finalCost  = totalCost - finalCombo

    }

    if (isDiscount) {
        println("======= Total after discount =======")
        println("=> Total cost ${"%.2f".format(finalCost)}")
    }











}