<?php
include 'config.php';
$idpardakht=$_GET['code'];

$loginclass = new rootview();
$price=(int)$loginclass->Get_price($idpardakht);

$MerchantID = 'you zarinpal MerchantID';
$Amount = $price;
$Description = 'فروشگاه انلاین لباس';
$CallbackURL = 'http://your domain/botik/pay/Status.php';


$client = new SoapClient('https://www.zarinpal.com/pg/services/WebGate/wsdl', ['encoding' => 'UTF-8']);

$result = $client->PaymentRequest(
    [
        'MerchantID' => $MerchantID,
        'Amount' => $Amount,
        'Description' => $Description,
        'CallbackURL' => $CallbackURL,
    ]
);
if ($result->Status == 100) {
    $loginclass->Get_order_update($result->Authority,$idpardakht,"0");
    Header('Location: https://www.zarinpal.com/pg/StartPay/'.$result->Authority);

} else {
    echo'ERR: '.$result->Status;
}