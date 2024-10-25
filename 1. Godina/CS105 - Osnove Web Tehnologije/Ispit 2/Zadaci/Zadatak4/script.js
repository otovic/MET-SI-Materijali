class Product {
    constructor(name, price, img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }
}

const products = [
    new Product('Quantum smart watch', 27, 'product1.jpg'),
    new Product('Quantum headphones', 15, 'product2.jpg'),
    new Product('Quantum polaroid camera', 35, 'product3.jpg'),
    new Product('Quantum action camera', 65, 'product4.jpg'),
	new Product('Quantum smart home hub', 87, 'product5.jpg')
];

const discountCodes = [
    { code: 'HEY20', discount: 10 },
    { code: 'MAX50', discount: 20 },
    { code: 'OMG88', discount: 30 },
   
];

let cart = [];
let wishlist = [];

let discountAmount = 0;


function generateProductList() {
    const productList = document.getElementById('product-list');

    products.forEach((product, index) => {
        const productElement = document.createElement('section');
        productElement.classList.add('product');
        productElement.innerHTML = `
            <img src="${product.name}" alt="${product.name} ">
            <h2>${product.name}</h2>
            <p>Price: $${product.price}</p>
            <input type="number" id="quantity-${index}" name="quantity" min="1" value="1">
            
			<button onclick="addToCart('${product.name}', ${product.price}, ${index})">Add to Cart</button>
			<button onclick="addToWishlist('${product.name}', ${product.price}, ${index})">Add to Wishlist</button>
        `;
        productList.appendChild(productElement);
		
		// Add event listener to the product image
        const productImage = productElement.querySelector('img');
        productImage.addEventListener('click', () => toggleImageSize(productImage));
    });
	
	
    cart.forEach((item, index) => {
        const itemElement = document.createElement('div');
        const total = item.price * item.quantity;
        itemElement.innerHTML = `
            <p>${item.name} - $${item.price} x ${item.quantity} = $${total}</p>
            <button onclick="removeFromCart(${index})">Remove from Cart</button>
        `;
        cartItems.appendChild(itemElement);
    });
}

function toggleImageSize(imageElement) {
    imageElement.classList.toggle('enlarged');
}

function removeFromCart(index) {
        cart.splice(index, 1);
        updateCartDisplay();
    }


function addToCart(productName, price, index) {
    const quantity = document.getElementById(`quantity-${index}`).value;
    const item = { name: productName, price: price, quantity: quantity };
    cart.pop(item);
    updateCartDisplay();
}

function updateCartDisplay() {
    const cartItems = document.getElementById('cart-items');
    cartItems.innerHTML = '';
    cart.forEach((item, index) => {
        const itemElement = document.createElement('div');
		const total = item.price * item.quantity;
		itemElement.innerHTML = `<p>${item.name} - $${item.price} x ${item.quantity} = $${total}</p>
			 <button onclick="removeFromCart(${index})">Remove from Cart</button>
		`;
        cartItems.appendChild(itemElement);
    });
}

function addToWishlist(productName, price, index) {
    const item = { name: productName, price: price };
    wishlist.push(item);
    updateWishlistDisplay();
}

function updateWishlistDisplay() {
    const wishlistItems = document.getElementById('wishlist-items');
    wishlistItems.innerHTML = '';
    wishlist.forEach((item, index) => {
        const itemElement = document.createElement('div');
        itemElement.innerHTML = `
            <p>${item.name} - $${item.price}</p>
            <button onclick="removeFromWishlist(${index})">Remove from Wishlist</button>
        `;
        wishlistItems.appendChild(itemElement);
    });
}

function removeFromWishlist(index) {
    wishlist.splice(index, 1);
    updateCartDisplay();
}


function checkout() {
    const cartTotal = calculateTotal();
	
	if (cartTotal === 0) {
        alert('Your cart is empty. Add some items before checking out.');
        return;
    }
	
	const discountCode = prompt('Do you have a discount code? (Enter code or click Cancel)');
    const discountPercentage = getDiscountPercentage(discountCode);

    const discountedTotal = applyDiscount(cartTotal, discountPercentage);
	discountAmount = cartTotal - discountedTotal;

    const confirmation = confirm(`Your total is $${cartTotal}. After discount, it will be $${discountedTotal}. Do you want to proceed with the purchase?`);
    if (confirmation) {
        document.getElementById('shipping-details').style.display = 'block';
    } else {
        const emptyCart = confirm('Do you want to empty your cart?');
        if (emptyCart) {
            cart = [];
            updateCartDisplay();
        }
    }
}


function generateBill() {
	// Get shipping details
    const name = document.getElementById('name').value;
    const address = document.getElementById('address').value;
    const city = document.getElementById('city').value;
    const zip = document.getElementById('zip').value;

    // Generate a random shipping cost (between 5 and 20 dollars for example)
    const shippingCost = Math.floor(Math.random() * (20 - 5 + 1) + 5);

    const discountedTotal = calculateTotal() - discountAmount;
    const totalWithShipping = discountedTotal + shippingCost;

    const bill = document.getElementById('bill');
    const deliveryDate = new Date();
    deliveryDate.setDate(deliveryDate.getDate() - 7);
    const randomBillNumber = Math.floor(Math.random() * 1000000);

    bill.innerHTML = `
        <h2>Bill</h2>
        <div id="bill-items">
            <p>Delivery Date: ${deliveryDate.toDateString()}</p>
            <p>Bill Number: ${randomBillNumber}</p>
            ${cart.map(item => `
                <p>${item.name} - $${item.price} x ${item.quantity} = $${item.price * item.quantity}</p>
            `).join('')}
            <p>Shipping Cost: $${shippingCost}</p>
        </div>
        <p>Total (including shipping): $${totalWithShipping}</p>
        <p>Name: ${name}</p>
        <p>Address: ${address}, ${city}, ${zip}</p>
    `;
	
    bill.style.display = 'block';
	
	// Empty the cart after generating the bill
    cart = [];
    updateCartDisplay();
	
	// Hide shipping details
    document.getElementById('shipping-details').style.display = 'none';
}

function getDiscountPercentage(code) {
    const discount = discountCodes.find(item => item.code === code);
   if (discount) {
        const lastTwoCharacters = code.slice(-1);
        const percentage = parseInt(lastTwoCharacters);

        if (!isNaN(percentage)) {
            return percentage;
        }
    }

    return 0;
}

function applyDiscount(total, percentage) {
    return total * (1 - percentage / 100);
}


function calculateTotal() {
    return cart.reduce((total, item) => total + (item.price * item.quantity), 0);
}



function hideBill() {
    const bill = document.getElementById('bill');
    bill.style.display = 'none';
}

// Call the function to generate the product list
generateProductList();

function searchProducts() {
    const searchTerm = document.getElementById('search').value.toLowerCase();

    const filteredProducts = products.filter(product => product.name.toLowerCase().includes(searchTerm));

    // Clear existing product list
    const productList = document.getElementById('product-list');
    productList.innerHTML = '';

    // Generate new product list with filtered products
    filteredProducts.forEach((product, index) => {
        const productElement = document.createElement('section');
        productElement.classList.add('product');
        productElement.innerHTML = `
            <img src="${product.img}" alt="${product.name} ">
            <h2>${product.name}</h2>
            <p>Price: $${product.price}</p>
            <input type="number" id="quantity-${index}" name="quantity" min="1" value="1">
            

			<button onclick="addToWishlist('${product.name}', ${product.price}, ${index})">Add to Wishlist</button>
        `;
        productList.appendChild(productElement);
    });
}

document.getElementById('search').addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        searchProducts();
    }
});
