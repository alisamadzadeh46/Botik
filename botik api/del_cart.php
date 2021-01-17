<?php
include 'config.php';
$id=$_POST['idcart'];

$loginclass = new rootview();
$loginclass->Del_cart($id);