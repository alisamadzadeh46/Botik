<?php
include 'config.php';
$check=$_POST['check'];
$token=$_POST['token'];
$prouct=$_POST['product'];
$count=$_POST['count'];
$loginclass = new rootview();
if($check=="add"){
$loginclass->Set_Addcart($token,$prouct,$count);
}
else if($check="m"){
    $loginclass->Set_manficart($token,$prouct,$count);
}