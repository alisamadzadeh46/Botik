<?php
include 'config.php';
$de=new rootview();
$id = @$_POST['id'];
$de->PostDetails($id);