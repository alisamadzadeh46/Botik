<?php
include 'config.php';
$token=$_POST['token'];

$loginclass = new rootview();
$loginclass->Record_cart_get($token);