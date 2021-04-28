<?php
$host="localhost";
$user="root";
$pwd="";
$db="aplikacja_mobilna";
$pot=$_POST["pot"];
$kat=$_POST["kat"];
$conn=mysqli_connect($host, $user, $pwd, $db);
if(!$conn)
{
	die("Error".mysqli_connect_error());
}

$s="SELECT p.nazwa,p.autor_rezyser,o.opis FROM obiekty as p inner join opis as o on p.opis_id=o.ido where p.nazwa = '".$pot."' and p.kategoria_id = (SELECT idk from kategoria where kategoria = '".$kat."')";

$res=mysqli_query($conn,$s);

if(mysqli_num_rows($res) == 0){
	echo "No results";
}

while($row=mysqli_fetch_assoc($res))
	{
		echo "NAME:"."\n\n".$row['nazwa']."\n\n";
		echo "AUTHOR/DIRECTORY:"."\n\n".$row['autor_rezyser']."\n\n";
		echo "DESCRIPTION:"."\n\n".$row['opis'];
 	}
?>