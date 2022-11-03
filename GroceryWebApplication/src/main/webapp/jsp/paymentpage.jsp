<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <!-- custom css file link  -->
    <link rel="stylesheet" href="/resources/css/payment.css">

</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container">

    <form action="paymentdecision">

        <div class="row">

            <div class="col">
     
                <input type="radio" name="paymentType" value="cards" checked="checked">
                <label for="cards">CARD</label><br>
             
                 <div class="inputBox">
                    <span>cards accepted :</span>
                    <img src="../resources/img/payment.png" alt="">
                </div>
                <div class="inputBox">
                    <span>name on card :</span>
                    <input type="text" placeholder="XXXXX" name="cardName">
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" placeholder="1111-2222-3333-4444" name="card">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" placeholder="january">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>exp year :</span>
                        <input type="number" placeholder="2022">
                    </div>
                    <div class="inputBox">
                        <span>CVV :</span>
                        <input type="text" placeholder="1234">
                    </div>
                </div>
                <div>
                <input type="radio" name="paymentType" value="cod">
                <label for="cod">COD (cash on delivery)</label>
            </div>

            </div>
   
        </div>

        <input type="submit" value="Make Payment Rs.${total}" class="submit-btn">

    </form>

</div>    
   
</body>
</html>