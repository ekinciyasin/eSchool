import React, { useState } from "react";
import {
  Modal,
  Button,
  Form,
  Alert,
  InputGroup,
  FormGroup,
} from "react-bootstrap";
import { request, setAuthHeader } from "../services/axios_helper";
import { useUser } from "../context/UserContext";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";

const LoginModal = ({ show, onHide }) => {
  const { loginUser } = useUser();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const [showPassword, setShowPassword] = useState(false);

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
    setError(null);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    setError(null);
  };

  const togglePasswordVisibility = () => {
    setShowPassword((prevShowPassword) => !prevShowPassword);
  };

  const onLogin = (e) => {
    e.preventDefault();
    request("POST", "/login", {
      username: username,
      password: password,
    })
      .then((response) => {
        setAuthHeader(response.data.token);
        loginUser(response.data); // Kullanıcı bilgilerini güncelle
        onHide();
      })
      .catch((error) => {
        setAuthHeader(null);
        setError("Invalid username or password");
      });
    console.log(username, password);
  };

  const isValidEmail = (value) => {
    // Eğer değer bir email formatına uygunsa true döner
    // Basit bir email kontrolü için kullanılabilir, daha kapsamlı bir kontrol yapmanız gerekebilir
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(value);
  };

  return (
    <Modal show={show} onHide={onHide} centered>
      <Modal.Header closeButton>
        <Modal.Title>Login</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {error && <Alert variant="danger">{error}</Alert>}
        <Form>
          <FormGroup>
            <Form.Label>Username</Form.Label>
            <InputGroup controlId="formUsername">
              <Form.Control
                type="text"
                placeholder="Enter username or email"
                value={username}
                onChange={handleUsernameChange}
              />
            </InputGroup>
          </FormGroup>
          <FormGroup className="mt-3">
            <Form.Label>Password</Form.Label>
            <InputGroup controlId="formPassword">
              <Form.Control
                type={showPassword ? "text" : "password"}
                placeholder="Enter password"
                value={password}
                onChange={handlePasswordChange}
              />
              <Button
                variant="outline-secondary"
                onClick={togglePasswordVisibility}
              >
                <FontAwesomeIcon icon={showPassword ? faEye : faEyeSlash} />
              </Button>
            </InputGroup>
          </FormGroup>
        </Form>
      </Modal.Body>
      <Button variant="link" onClick={onLogin}>
        Forgot Password?
      </Button>
      <Modal.Footer>
        <Button variant="secondary" onClick={onHide}>
          Close
        </Button>
        <Button variant="primary" onClick={onLogin}>
          Login
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default LoginModal;
