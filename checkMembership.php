<?php
// Database configuration
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "membershipApp";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if the data is sent via POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Assuming you're sending 'mobileNo' parameter from Android
    $mobileNo = $_POST['mobileNo'];

    // SQL query to check if the mobile number exists in the database
    $sql = "SELECT * FROM checkUser WHERE mobile_mobileNo = '$mobileNo'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        // Mobile number exists in the database
        echo json_encode(array('status' => true));
    } else {
        // Mobile number does not exist in the database
        echo json_encode(array('status' => false));
    }
}

$conn->close();
?>

