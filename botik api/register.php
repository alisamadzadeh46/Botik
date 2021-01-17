<?php
include 'config.php';
$username=@$_POST['username'];
$password=@$_POST['password'];
$r_register=new rootview();
if(isset($_POST['username'])&& isset($_POST['password']))
{
    $r_register->GetRegister($username,$r_register->hashPassword($password));

 
}

