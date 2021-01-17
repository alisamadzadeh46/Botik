<?php
include 'config.php';
$username=@$_POST['username'];
$password=@$_POST['password'];

$loginclass = new rootview();
$loginclass->Getlogin($username,$loginclass->hashPassword($password));