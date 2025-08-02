fun main(){
        //1.    Define Products (Arrays/Lists)
        val productNames = listOf("Laptop", "Mouse", "Keyboard", "Monitor", "Webcam")
        val productPrices = listOf("999.99","25.50","45.40","189.99","49.99")

        //2.   Display Products (Loops)
        var index = 0;
        for (name in productNames){
            println("${index+1}. $name ${productPrices[index]}")
            index++
        }

       //3.    Simulate Shopping Cart (MutableList)
       val shoppingCart = mutableListOf<String>()
       input@ while (true) {
           print("Enter the product name:")
           val productName = readLine()!!.trim()

           if (productName.lowercase().equals("Done".lowercase())) {
               println("Shopping cart $shoppingCart")
               break;
               }
           var found = false;

            //loop to find item
            for (product in productNames){
               if (productName.lowercase().equals(product.lowercase())){
                   shoppingCart.add(product)
                   println("Added $product")
                   println(shoppingCart)
                   found = true
                   break

               }


           }
           if (!found){
               println("Products ${productName} not match")
            }


       }

       //4.    Calculate Order Total (Loops & Conditions)
        var totalCost = 0.0
        var price = 0.0
        for (itemName  in productNames){


            for (productShopping in shoppingCart){
                if (productShopping.lowercase().equals(itemName.lowercase())){
                    var indexProductName = productNames.indexOf(productShopping)
                    price = productPrices[indexProductName].toDouble()
                    totalCost += price
                }
            }


        }
}