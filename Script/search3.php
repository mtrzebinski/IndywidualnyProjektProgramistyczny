<?php
$host="localhost";
$user="root";
$pwd="";
$db="aplikacja_mobilna";
$pot=$_POST["pot"];
$kat=$_POST["kat"];
$skd=$_POST["skd"];
$op=$_POST["op"];
$conn=mysqli_connect($host, $user, $pwd, $db);
if(!$conn)
{
	die("Error".mysqli_connect_error());
}

$co="select opis from opis where opis='".$op."'";
$cs="select nazwa from obiekty where nazwa='".$pot."'";
$res1=mysqli_query($conn,$co);
$res2=mysqli_query($conn,$cs);

if (mysqli_num_rows($res1)==0){
	$o="insert into opis(opis) values('".$op."')";
	mysqli_query($conn,$o);
}

if (mysqli_num_rows($res2)<=0){
	$s="insert into obiekty(nazwa, autor_rezyser, kategoria_id, opis_id) values('".$pot."', '".$skd."', (select idk from kategoria where kategoria = '".$kat."'), (select ido from opis where opis = '".$op."'))";
	mysqli_query($conn,$s);
	echo "ADDED TO DATABASE";
}
else {
	echo "THIS IS ALREADY ADDED!";
}




?>