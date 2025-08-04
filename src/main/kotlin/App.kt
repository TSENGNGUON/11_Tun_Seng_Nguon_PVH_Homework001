import kotlin.math.pow

fun main() {
    // Step 1: Define Products (Arrays/Lists)
    val productNames = listOf(
        "Laptop", "Mouse", "Keyboard", "Monitor", "Webcam", "Wireless Charger",
        "USB Hub", "Headphones", "External Hard Drive", "Smartphone", "Tablet",
        "Bluetooth Speaker", "Printer", "Graphics Card", "Desk Lamp", "Office Chair", "Microphone"
    )

    val productPrices = listOf(
        999.99, 25.50, 45.40, 189.99, 49.99, 29.99,
        15.00, 89.99, 79.50, 699.99, 399.99,
        59.99, 149.99, 349.99, 24.99, 129.99, 25.99
    )

    val invalidProduct = mutableListOf<String>()

    // Step 2: Display Products
    var index = 0
    for (name in productNames) {
        println("${index + 1}. $name $${productPrices[index]}")
        index++
    }

    // Step 3: Simulate Shopping Cart
    val shoppingCart = mutableListOf<String>()

    input@ while (true) {
        println()
        print("Enter the product name: ")
        val productName = readLine()!!.trim()
        var found = false

        if (productName.equals("Done", ignoreCase = true)) {
            println("=== Your Shopping Cart ===")
            println("=> Shopping cart: $shoppingCart")
            break
        }

        for (product in productNames) {
            if (productName.equals(product, ignoreCase = true)) {
                shoppingCart.add(product)
                println("................")
                print("Added $product")
                print(" => Your Cart Update: ")
                println(shoppingCart)
                found = true
                break
            }
        }

        if (!found) {
            println("................")
            println("Product '$productName' not found")
            invalidProduct.add(productName)
        }
    }

    var isBothCombo = false

    // Step 4: Calculate Order Total
    var totalCost = 0.0
    var price = 0.0
    var foundItem = false

    for (itemName in productNames) {
        for (item in shoppingCart) {
            if (item.equals(itemName, ignoreCase = true)) {
                val indexProductName = productNames.indexOf(item)
                price = productPrices[indexProductName]
                totalCost += price
                foundItem = true
            }
        }
    }

    if (foundItem) {
        println("=> Total cost: $${"%.2f".format(totalCost)}")

    }


    if (foundItem && invalidProduct.isNotEmpty()) {
        println("................")
        println("Warning: Product '${invalidProduct}' not found in catalog.")
    }

    // Step 5: Apply Discount (Conditional)
    var count = 0
    val flatDiscount = 10.00
    var finalCost = totalCost
    var laptopMouseDis = 0.0
    var headPhoneMicrophoneDis = 0.0
    var isDiscount = false
    var discount = 0.0

    // Combo: Laptop + Mouse (8% off all mouse)
    if (shoppingCart.any { it.equals("Laptop", ignoreCase = true) } &&
        shoppingCart.any { it.equals("Mouse", ignoreCase = true) }
    ) {
        isDiscount = true

        for (item in shoppingCart) {
            if (item.equals("Mouse", ignoreCase = true)) {
                count++
            }
        }

        val mouseIndex = productNames.indexOf("Mouse")
        val mousePrice = productPrices[mouseIndex]
        val totalMouse = mousePrice * count
        discount = totalMouse * 0.08
        laptopMouseDis = totalCost - discount
        finalCost = laptopMouseDis
    }

    // Combo: Headphones + Microphone ($10 flat off)
    if (shoppingCart.any { it.equals("Headphones", ignoreCase = true) } &&
        shoppingCart.any { it.equals("Microphone", ignoreCase = true) }
    ) {
        isDiscount = true
        headPhoneMicrophoneDis = totalCost - flatDiscount
        finalCost = headPhoneMicrophoneDis
    }

    // Combo: Both combos present
    if (
        shoppingCart.any { it.equals("Laptop", ignoreCase = true) } &&
        shoppingCart.any { it.equals("Mouse", ignoreCase = true) } &&
        shoppingCart.any { it.equals("Headphones", ignoreCase = true) } &&
        shoppingCart.any { it.equals("Microphone", ignoreCase = true) }
    ) {
        isDiscount = true
        val finalCombo = discount + flatDiscount
        finalCost = totalCost - finalCombo
    }


    var premiumTier = 1500.00
    var standardTier = 500.00
    if (totalCost > premiumTier){
        isDiscount = true
    }else if (totalCost > standardTier){
        isDiscount = true
    }

    if (isDiscount) {
        println("======= Total after discount =======")


        if (finalCost > premiumTier){
            var tenPercentage = 0.1
            var discountFinalPrice = totalCost * tenPercentage
            finalCost = totalCost - discountFinalPrice


        }else if (finalCost > standardTier){
            var fivePercentage = 0.05
            var discountFinalPrice = totalCost * fivePercentage
            finalCost = totalCost - discountFinalPrice
        }
        println("=> Total cost: $${"%.2f".format(finalCost)}")
    }
}
