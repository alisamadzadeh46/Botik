<!doctype html>
<html lang="en">
<head>
    <title> رسید پرداخت </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/rtl.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
<!doctype html>
<html lang="en">
<head>
    <title> رسید پرداخت </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/rtl.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">

    <div class="container-login100">

        <div class="wrap-login100">
            <form class="login100-form validate-form">
                <span class="login100-form-title p-b-26 asirefontshod" style="font-family: Samim,serif">
                            وضعیت پرداخت
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>
                <p class="asirefontshod f" style="font-family: Samim,serif">

                    <?php
                    include '../config.php';
                    $Authority = $_GET['Authority'];
                    $ChekClass = new rootview();
                    $price = (int)$ChekClass->GetPriceCheck($Authority);
                    $MerchantID = 'your MerchantID';
                    $Amount = $price;
                    $status = 'پرداخت نشده';
                    if ($_GET['Status'] == 'OK') {

                        $client = new SoapClient('https://www.zarinpal.com/pg/services/WebGate/wsdl', ['encoding' => 'UTF-8']);

                        $result = $client->PaymentVerification(
                            [
                                'MerchantID' => $MerchantID,
                                'Authority' => $Authority,
                                'Amount' => $Amount,
                            ]
                        );

                        if ($result->Status == 100) {
                            echo 'تراکنش با موفقیت انجام شد. شماره تراکنش:' . $result->RefID;
                            $ChekClass->ChekPardakht($Authority, "1");
                            $status = 'پرداخت شده';
                        } else {
                            $status = 'پرداخت نشده';
                            echo 'پرداخت با شکست مواجه شده';
                            $ChekClass->ChekPardakht($Authority, "0");
                        }
                    } else {
                        echo 'لغو شده توسط کاربر';
                        $ChekClass->ChekPardakht($Authority, "0");
                    }

                    ?>

                </p>

            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>

   
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>