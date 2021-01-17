<?php

class rootview
{
    public $conn;

    function __construct()
    {
        header("Content-type: application/json; charset=utf-8");
        $this->conn = new PDO("mysql:host=localhost;dbname=your db name;charset=utf8", "your username host", " your password host");
    }


    function hashPassword($value)
    {

        $salt = sha1('!@#$%^&*()1234567789alisamadzadeh.ir9090123');
        return trim(crypt($value, $salt));

    }

    function GetRegister($username,$password)
    {

        $token = $this->createTorken();
        $array = array();
        $sql = "select username  from User where username='$username'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();

        if ($stmt->rowCount() == 1) {
            $array['status'] = "error";
            echo json_encode($array);

        } else {

            $sql = "insert into User(username,password,token) values ('$username','$password','$token')";
            $sql_query = $this->conn->prepare($sql);
            $sql_query->execute();
            if ($this->conn->lastInsertId()) {
                $array['status'] = "ok";
                $array['token'] = $token;
                echo json_encode($array);

            }
        }
    }


    function Get_user_info($token)
    {

        $sql = "SELECT username FROM User where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);


    }



    function Getlogin($username, $password)
    {
        $array = array();
        $sql = "select count(username) as num,token from User where password='$password' and username='$username'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($row['num'] > 0) {
            $array['status'] = "ok";
            $array['token'] = $row['token'];
            echo json_encode($array);
        } else {

            $array['status'] = "error";
            echo json_encode($array);

        }
    }


    function createTorken(){

        return $_SESSION['token']=md5(microtime().rand());
    }

    public function CheckCode($phone,$code){
        $array = array();
        $sql = "select count(phone) as num,token from User where phone='$phone' and code='$code'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['num'] > 0) {
            $array['status'] = "ok";
            $array['token'] = $row['token'];
            $sql = "update User set code='true',status='true' where phone='$phone'";
            echo json_encode($array);

        } else {

            $array['status'] = "error";
            echo json_encode($array);

        }
    }

  
        $array = array();
        $sql = "select count(phone) as num,token  from User where phone='$phone'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['num'] > 0) {
            $code=floor(rand(11111,99999));
            $array['status'] = "ok";
            $sql = "update User set code='$code',status='false' where phone='$phone'";
            $sql_query = $this->conn->prepare($sql);
            $sql_query->execute();
            echo json_encode($array);

            $url = "https://ippanel.com/services.jspd";

            $rcpt_nm = array($phone);
            $param = array
            (
                'uname'=>'hoteljostejo',
                'pass'=>'e%^H4kj3r',
                'from'=>'2000145',
                'message'=>'کد شما در مهندسی پزشکی'.$code,
                'to'=>json_encode($rcpt_nm),
                'op'=>'send'
            );

            $handler = curl_init($url);
            curl_setopt($handler, CURLOPT_CUSTOMREQUEST, "POST");
            curl_setopt($handler, CURLOPT_POSTFIELDS, $param);
            curl_setopt($handler, CURLOPT_RETURNTRANSFER, true);
            $response2 = curl_exec($handler);

            $response2 = json_decode($response2);
            $res_code = $response2[0];
            $res_data = $response2[1];


        } else {

            $array['status'] = "error";
            echo json_encode($array);


        }

    }

    public function CheckCodeForget($phone,$code){
        $token = $this->createTorken();
        $array = array();
        $sql = "select count(phone) as num,token from User where phone='$phone' and code='$code'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['num'] > 0) {
            $sql = "update User set code='true',status='true',token='$token'where phone='$phone'";
            $array['status'] = "ok";
            $array['token'] = $row['token'];
            echo json_encode($array);

        } else {

            $array['status'] = "error";
            echo json_encode($array);

        }
    }


    public function ChangePassword($phone,$password){
        $array = array();
        $sql = "select count(phone) as num,token  from User where phone='$phone'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['num'] > 0) {

            $array['status'] = "ok";
            $sql = "update User set code='true',status='true',password='$password' where phone='$phone'";
            $sql_query = $this->conn->prepare($sql);
            $sql_query->execute();
            echo json_encode($array);

        } else {

            $array['status'] = "error";
            echo json_encode($array);


        }

    }

    function getPost()
    {
        $sql = "SELECT * FROM Post ";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }

    public function PostDetails($id){
        $array=array();
        $sqlpost="SELECT image from Slider where idpost='$id'";
        $sql_query = $this->conn->prepare($sqlpost);
        $sql_query->execute();
        $array['slider']=$sql_query=$sql_query->fetchAll(2);



        $sqlpost="SELECT * from Post where idpost='$id'";
        $sql_query = $this->conn->prepare($sqlpost);
        $sql_query->execute();
        $array['post']=$sql_query=$sql_query->fetchAll(2);
        echo json_encode($array);
    }

    public function Set_Add_Address($token, $address, $codeposti, $phone, $phonesabet)
    {

        $array = array();
        $sql = "insert into address(token,address,codeposti,phone,phonesabet) values ('$token','$address','$codeposti','$phone','$phonesabet')";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        if ($this->conn->lastInsertId()) {
            $array['status'] = "ok";
            echo json_encode($array);
        } else {
            $array['status'] = "error";
            echo json_encode($array);
        }
    }

    public function List_order($token)
    {
        $sql = "select * from tbl_order where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }

    public function Set_Addcart($token, $procut, $count)
    {
        $array = array();
        $sql = "select price from Post where idpost='$procut'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['price'] != null) {


            $sql = "select count(idproduct) as num from Cart where token='$token' and idproduct='$procut'";
            $stmt = $this->conn->prepare($sql);
            $stmt->execute();
            $row_2 = $stmt->fetch(PDO::FETCH_ASSOC);

            if ($row_2['num'] > 0) {

                $sql = "select price,count from Cart where idproduct='$procut' and token= '$token'";
                $stmt = $this->conn->prepare($sql);
                $stmt->execute();
                $row_3 = $stmt->fetch(PDO::FETCH_ASSOC);

                $last_update_price = ($row['price']) * $count;
                $updatelast_price = $row_3['price'] + $last_update_price;
                $updatelast_count = $row_3['count'] + $count;


                $sql = "update Cart set price='$updatelast_price',count='$updatelast_count' where idproduct='$procut' and token='$token'";
                $sql_query = $this->conn->prepare($sql);
                $sql_query->execute();


                $sql = "SELECT sum(price) as price from Cart";
                $sql_query = $this->conn->prepare($sql);
                $sql_query->execute();
                $sql_query = $sql_query->fetchAll(2);

                $sql = "select price from Cart where token='$token' and idproduct='$procut'";
                $stmt = $this->conn->prepare($sql);
                $stmt->execute();
                $row_price = $stmt->fetch(PDO::FETCH_ASSOC);

                $array['status'] = 'ok';
                $array['count'] =  $updatelast_count;
                $array['price'] = $sql_query;
                $array['price_post'] = $row_price['price'];

            } else {

                $lastprice = ($row['price']) * $count;
                $sql = "insert into Cart (token,idproduct,count,price) values ('$token','$procut','$count','$lastprice')";
                $sql_query = $this->conn->prepare($sql);
                $sql_query->execute();
                if ($this->conn->lastInsertId()) {
                    $array['status'] = 'ok';

                    $sql = "SELECT sum(price) as price from Cart";
                    $sql_query = $this->conn->prepare($sql);
                    $sql_query->execute();
                    $sql_query = $sql_query->fetchAll(2);
                    $array['price'] = $sql_query;
                } else {
                    $array['status'] = 'error';
                }
            }

        } else {
            $array['status'] = 'error';
        }

        echo json_encode($array);

    }


    public function Set_manficart($token, $procut, $count)
    {
        $array = array();
        $sql = "select price from Post where idpost='$procut'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row['price'] != null) {

            $sql = "select count(idproduct) as num from Cart where token='$token' and idproduct='$procut'";
            $stmt = $this->conn->prepare($sql);
            $stmt->execute();
            $row_2 = $stmt->fetch(PDO::FETCH_ASSOC);

            if ($row_2['num'] > 0) {

                $sql = "select price,count from Cart where idproduct='$procut' and token= '$token'";
                $stmt = $this->conn->prepare($sql);
                $stmt->execute();
                $row_3 = $stmt->fetch(PDO::FETCH_ASSOC);
                $last_update_price = ($row['price']) * $count;
                $updatelast_price = $row_3['price'] - $last_update_price;
                $updatelast_count = $row_3['count'] - $count;

                if ($updatelast_count != 0) {
                    $array['count'] = $updatelast_count;
                    $sql = "update Cart set price='$updatelast_price',count='$updatelast_count' where idproduct='$procut' and token='$token'";
                    $sql_query = $this->conn->prepare($sql);
                    $sql_query->execute();
                    $sql = "SELECT sum(price) as price from Cart";
                    $sql_query = $this->conn->prepare($sql);
                    $sql_query->execute();
                    $sql_query = $sql_query->fetchAll(2);


                    $sql = "select price from Cart where token='$token' and idproduct='$procut'";
                    $stmt = $this->conn->prepare($sql);
                    $stmt->execute();
                    $row_price = $stmt->fetch(PDO::FETCH_ASSOC);
                    $array['status'] = 'ok';
                    $array['price'] = $sql_query;
                    $array['price_post']=$row_price['price'];
                } else {
                    $array['status'] = 'error';
                }
            }

        } else {
            $array['status'] = 'error';
        }

        echo json_encode($array);

    }


    public function Del_cart($id)
    {

        $sql = "select count(id) as num from Cart where id='$id'";
        $stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $row_2 = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($row_2['num'] > 0) {
            $array = array();
            $sql = "delete from Cart where id='$id'";
            $stmt = $this->conn->prepare($sql);
            $stmt->execute();
            $array['status'] = 'ok';
        } else {
            $array['status'] = 'error';
        }

        echo json_encode($array);
    }

    public function Record_Cartcount($token)
    {
        $sql = "select COUNT(*) as count from Cart where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetch(2);
        echo json_encode($sql_query);
    }

    public function Record_cart_get($token)
    {
        $sql = "select * from Post,Cart where Post.idpost=Cart.idproduct and Cart.token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }
    public function Get_Cartpricenumber($token)
    {
        $sql = "SELECT sum(price) as price from Cart where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }
    public function More_list_order($idorder)
    {
        $sql = "select * from tbl_order,address where tbl_order.idaddress=address.id and tbl_order.id='$idorder'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }
    public function Get_Address($token)
    {
        $sql = "select * from address where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }

    public function Get_price($code){
        $sql = "select price from tbl_order where code_pardakht='$code'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetch(PDO::FETCH_ASSOC);
        return $sql_query['price'];
    }


     public function GetPriceCheck($Authority){
        $sql = "select price from tbl_order where Authority='$Authority'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetch(PDO::FETCH_ASSOC);
        return $sql_query['price'];
    }

    public function ChekPardakht($Authority,$status){
        $sql = "update tbl_order set status='$status' where Authority='$Authority'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
    }

    public function Get_order_update($Authority,$id,$status){
        $sql = "update tbl_order set status='$status',Authority='$Authority' where code_pardakht='$id' ";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
    }



    public function Get_pay()
    {
        $sql = "select * from Pay";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }

    public function Add_order($token, $idaddress)
    {
        $array = array();
        $sql = "SELECT sum(price) as price from Cart where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetch(PDO::FETCH_ASSOC);
        $price = (int)$sql_query['price'];
        $code=rand(1,100000);
        $sql = "insert into tbl_order(token,idaddress,price,status,code_pardakht) values ('$token','$idaddress','$price','0','$code')";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        if ($this->conn->lastInsertId()) {
            $array['status'] = "ok";
            $array['price'] = $price;
            $array['code'] = $code;
            $array['order'] = $this->conn->lastInsertId();
            echo json_encode($array);
        } else {
            $array['status'] = "error";
            echo json_encode($array);
        }
    }
    
    public function ShowData($token)
    {
        $sql = "select address,codeposti,phone,phonesabet from address where token='$token'";
        $sql_query = $this->conn->prepare($sql);
        $sql_query->execute();
        $sql_query = $sql_query->fetchAll(2);
        echo json_encode($sql_query);
    }




}