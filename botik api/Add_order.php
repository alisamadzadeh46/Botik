<?php
include 'config.php';
$token=$_POST['token'];
$idaddress=$_POST['address'];

$loginclass = new rootview();
$loginclass->Add_order($token,$idaddress);