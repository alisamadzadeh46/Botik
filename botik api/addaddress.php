<?php
include 'config.php';
$token=@$_POST['token'];
$address=@$_POST['address'];
$codeposti=@$_POST['codeposti'];
$phone=@$_POST['phone'];
$phonesabet=@$_POST['phonesabet'];
$loginclass = new rootview();
$loginclass->Set_Add_Address($token,$address,$codeposti,$phone,$phonesabet);