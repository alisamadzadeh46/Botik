<?php

include_once("functions.php");
$api = '48c63588c0f10d0dc295e4026b23b737';
$amount = "10000";
$mobile = "your phone number";
$factorNumber = "شماره فاکتور";
$description = "توضیحات";
$redirect = 'your domain';
$result = send($api, $amount, $redirect, $mobile, $factorNumber, $description);
$result = json_decode($result);
if($result->status) {
    $go = "https://pay.ir/pg/$result->token";
    header("Location: $go");
} else {
    echo $result->errorMessage;
}