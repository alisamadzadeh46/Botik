<?php
include 'config.php';
$idorder=$_POST['idorder'];

$loginclass = new rootview();
$loginclass->More_list_order($idorder);
