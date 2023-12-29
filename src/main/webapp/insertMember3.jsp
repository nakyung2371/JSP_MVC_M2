<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 폼</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .signup-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            width: 400px;
            max-width: 100%;
            padding: 20px;
            box-sizing: border-box;
        }

        .signup-container h2 {
            text-align: center;
            color: #333;
        }

        .signup-form {
            display: flex;
            flex-direction: column;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-size: 14px;
            color: #555;
            margin-bottom: 8px;
            display: block;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .form-group input:focus {
            border-color: #3498db;
            outline: none;
        }

        .form-group button {
            background-color: #3498db;
            color: #fff;
            font-size: 16px;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #217dbb;
        }

        .error-message {
            color: #e74c3c;
            font-size: 14px;
            margin-top: 5px;
        }
    </style>
</head>
<body>

<div class="signup-container">
    <h2>회원가입</h2>
    <form class="signup-form" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="username" required>
            <div id="usernameError" class="error-message"></div>
        </div>
        <div class="form-group">
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" required>
            <div id="emailError" class="error-message"></div>
        </div>
        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
            <div id="passwordError" class="error-message"></div>
        </div>
        <div class="form-group">
            <label for="confirmPassword">비밀번호 확인:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <div id="confirmPasswordError" class="error-message"></div>
        </div>
        <div class="form-group">
            <label for="phone">핸드폰 번호:</label>
            <input type="tel" id="phone" name="phone" required>
            <div id="phoneError" class="error-message"></div>
        </div>
        <div class="form-group">
            <label for="address">주소:</label>
            <input type="text" id="address" name="address" required>
            <div id="addressError" class="error-message"></div>
        </div>
        <div class="form-group">
            <button type="submit">가입하기</button>
        </div>
    </form>
</div>

<script>
    function validateForm() {
        var username = document.getElementById('username').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        var phone = document.getElementById('phone').value;
        var address = document.getElementById('address').value;

        var usernameError = document.getElementById('usernameError');
        var emailError = document.getElementById('emailError');
        var passwordError = document.getElementById('passwordError');
        var confirmPasswordError = document.getElementById('confirmPasswordError');
        var phoneError = document.getElementById('phoneError');
        var addressError = document.getElementById('addressError');

        // 초기화
        usernameError.innerHTML = "";
        emailError.innerHTML = "";
        passwordError.innerHTML = "";
        confirmPasswordError.innerHTML = "";
        phoneError.innerHTML = "";
        addressError.innerHTML = "";

        if (username.length < 3) {
            usernameError.innerHTML = "아이디는 3자 이상이어야 합니다.";
            return false;
        }

        var emailPattern = /\S+@\S+\.\S+/;
        if (!emailPattern.test(email)) {
            emailError.innerHTML = "유효한 이메일을 입력하세요.";
            return false;
        }

        if (password.length < 6) {
            passwordError.innerHTML = "비밀번호는 6자 이상이어야 합니다.";
            return false;
        }

        if (password !== confirmPassword) {
            confirmPasswordError.innerHTML = "비밀번호가 일치하지 않습니다.";
            return false;
        }

        // 간단한 핸드폰 번호 유효성 체크
        var phonePattern = /^\d{3}-\d{3,4}-\d{4}$/;
        if (!phonePattern.test(phone)) {
            phoneError.innerHTML = "유효한 핸드폰 번호를 입력하세요 (예: 010-1234-5678).";
            return false;
        }

        if (address.trim() === "") {
            addressError.innerHTML = "주소를 입력하세요.";
            return false;
        }

        // 추가적인 유효성 체크를 원하는 대로 추가할 수 있습니다.

        // 모든 조건이 충족되면 true 반환
        return true;
    }
</script>

</body>
</html>
