<?php
include 'config.php';
$token=$_POST['token'];

$loginclass = new rootview();
$loginclass->Record_Cartcount($token);
