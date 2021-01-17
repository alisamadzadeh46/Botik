<?php
include 'config.php';
$token=$_POST['token'];

$loginclass = new rootview();
$loginclass->ShowData($token);
