<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="with=device-width,initial-scale=1.0">
        <title>
            Home page
        </title>
        <link rel="stylesheet" href="/resources/css/home.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.2/css/fontawesome.min.css">
    </head>
    <body>
        <section class="header">
           
               <!-- <a href="index.html"><img src="images/logo.jpg"></a>-->
               <nav>
                <div class="nav-links" id="navLinks">
                    <i class="fa fa-times" onclick="hideMenu()"></i>
                    <ul>
                        <li><a href="#products">Products</a></li>
                        <li><a href="#features">Features</a></li>
                        <li><a href="#About Us">About Us</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <li><a href="CustomerLogin">Login</a></li>

                    </ul>
                </div>
                <i class="fa fa-bars" onclick="showMenu()"></i>
            </nav>
            <div class="text-box">
                <h1>Online Grocery Store</h1>
                <p>The multipurpose grocery brand.</p>
                <a href="" class="hero-btn">Scroll Down to know more</a>
            </div>

        </section>
<!------------------products------------------>
<h1 id="products"></h1>
<section class="products">
    <h1>Products We offer</h1>
    <p>Firmest Products Ever</p>
    <div class="row">
        <div class="products-col">
            <img src="../resources/img/dairy.jpg">
            <h3>Dairy</h3>
            <p>Eat Healthily, be healthy<br>
                Taste the goodness of dairy Power</p>
        </div>

        <div class="products-col">
            <img src="../resources/img/meat.jpg">
            <h3>Fresh Meat</h3>
            <p>Cut the meat and beat.<br>
                Meat are love for some people.<br>
                Make your meat for your sweet.</p>
        </div>

        <div class="products-col">
            <img src="../resources/img/fruits.jpg">
            <h3>Fruits and Vegetables</h3>
            <p>Eat fruits everywhere<br>
                fresh fruit for you<br>
                Fresh fruit stay cool</p>
        </div>
    </div>

        <div class="row2">
        <div class="products-col">
            <img src="../resources/img/greentea.jpg">
            <h3>Boost Metabolism</h3>
            <p> A Whole New Way to Take Your Vitamins.</p>
        </div>
        <div class="products-col">
            <img src="../resources/img/horliks.jpg">
            <h3>Health Suppliments</h3>
            <p>Get healthier for a long life<br>
                Grow your muscles with our supplements<br>
                Supplements that heals</p>
        </div>
        <div class="products-col">
            <img src="../resources/img/soft.jpg">
            <h3>Soft Drinks</h3>
            <p>A Moments of Thrill<br>
                a life full of celebration<br>
                Let’s take a new Sip</p>
        </div>
    </div>
</section>

<!---------------------------Our Features------------------------------------------------------->
<h1 id="features"></h1>
<section class="features">
    <h1>Our Features</h1>
    <p>features like no-where</p>

    <div class="row">
        <div class="features-col">
            <img src="../resources/img/organic.jpg">
            <h3>fresh and organic</h3>
            <p>Organic product for the fruity fun</p>
        </div>
        <div class="features-col">
            <img src="../resources/img/delivery.jpg">
            <h3>Free Delivery</h3>
            <p>Giving you ideal help is our pride</p>
        </div>
        <div class="features-col">
            <img src="../resources/img/payments.jpg">
            <h3>Easy Payments</h3>
            <p>You better be on time for pay day</p>
        </div>
    </div>
</section>
<!--------------testimonials----------------------->
<h1 id="testimonials"></h1>
<section class="testimonials">
    <h1>What Our Customers say</h1>
    <p>Experts Views</p>
    <div class="row">
        <div class="testimonial-col">
            <img src="../resources/img/ts1.jpg">
        <div>
            <p>A pandemic.<br> Fear and an attempt to be socially responsible led consumers to begin using online grocery at rates that were completely unpredicted and more impactful than any marketing campaigns of the past. </p>
            <h3>sohail</h3>
        </div>

        </div>

        <div class="testimonial-col">
            <img src="../resources/img/ts2.jpg">
        <div>
            <p> In a major city, there are bodegas or convenience stores on every corner.<br> In the suburbs, there’s always a supermarket on the way home from work or soccer practice. <br>Depending on what a family is craving, it might even be easier to stop at the grocery store on any given night than try and predict what a week’s worth of food could look like ahead of time.</p>
            <h3>abhishek</h3>
        </div>

        </div>
    </div>

</section>


<!----------------------------------call to action--------------------->
<h1 id="contact"></h1>
<section class="contact">
    <div class="contact-form">
        <h1>Contact<span>Us</span></h1>
        <p>We Provide A Great Service. <br>In Order Of Querries Reach Out To Our Website</p>
        <form action="">
            <input type="" placeholder="Your Name" required>
            <input type="email" name="email" placeholder="E-Mail" required>
            <input type="" placeholder="Write Subject" required>
            <textarea name="" id="" cols="" rows="" placeholder="Your Message">
            </textarea>
            <input type="submit" name="" value="submit" class="btn">
        </form>
    </div>
    <div class="contact-img">
        <img src="../resources/img/contact.jpg">
    </div>

</section>


        <!---javascript for togglel menu-->
<script>
    var navLinks = document.getElementById("navLinks");
    function showMenu(){
        navLinks.style.left="0";
    }
    function hideMenu(){
        navLinks.style.left="-200px";
    }
</script>

   
<!----------------------------------footer--------------------->
<h1 id="About Us"></h1>
<section class="footer">
    <h4>About</h4>
    <p>Our Strore is India’s largest online food and grocery store.<br> With over 18,000 products and over a 1000 brands in our catalogue you will find everything you are looking for. Right from fresh Fruits and Vegetables, Rice and Dals, Spices and Seasonings to Packaged products, Beverages, Personal care products, Meats – we have it all.<br>
        Choose from a wide range of options in every category, exclusively handpicked to help you find the best quality available at the lowest prices.<br> Select a time slot for delivery and your order will be delivered right to your doorstep, anywhere in Bangalore, Hyderabad, Mumbai, Pune, Chennai, Delhi, Noida, Mysore, Coimbatore, Vijayawada-Guntur, Kolkata, Ahmedabad-Gandhinagar, Lucknow-Kanpur, Gurgaon, Vadodara, Visakhapatnam, Surat, Nagpur, Patna, Indore and Chandigarh Tricity You can pay online using your debit / credit card or by cash / sodexo on delivery.
        We guarantee on time delivery, and the best quality!</p><br></br>
        <p>Our Store allows you to walk away from the drudgery of grocery shopping and welcome an easy relaxed way of browsing and shopping for groceries.<br> Discover new products and shop for all your food and grocery needs from the comfort of your home or office. No more getting stuck in traffic jams, paying for parking, standing in long queues and carrying heavy bags – get everything you need, when you need, right at your doorstep. Food shopping online is now easy as every product on your monthly shopping list, is now available online at our atore, India’s best online grocery store.</p>
    <div class="icons">
    <i class="fa fa-facebook"></i>
    <i class="fa fa-twitter"></i>
    <i class="fa fa-linkedin"></i>
    <i class="fa fa-instgram"></i>
</div>
<p>Made With</p>
</section>
</body>
</html>