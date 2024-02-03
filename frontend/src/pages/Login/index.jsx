import React, { useEffect, useState } from "react";
import {
  Modal,
  Button,
  Form,
  Alert,
  InputGroup,
  FormGroup,
} from "react-bootstrap";
import { request, setAuthHeader } from "../../services/axios_helper";
import { useUser } from "../../context/UserContext";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import Input from "./components/Input";

const LoginModal = ({ show, onHide }) => {
  const { loginUser } = useUser();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});
  const [generalError, setGeneralError] = useState();

  useEffect(() => {
    setErrors(function (lastErrors) {
      return {
        ...lastErrors,
        username: undefined,
      };
    });
  }, [username]);
  useEffect(() => {
    setErrors(function (lastErrors) {
      return {
        ...lastErrors,
        password: undefined,
      };
    });
  }, [password]);

  const onChangeUsername = (event) => {
    setUsername(event.target.value);
    setGeneralError(null);
  };

  const onChangePassword = (event) => {
    setPassword(event.target.value);
    setGeneralError(null);
  };

  const onLogin = (e) => {
    e.preventDefault();
    setGeneralError();
    request("POST", "/login", {
      username: username,
      password: password,
    })
      .then((response) => {
        setAuthHeader(response.data.token);
        loginUser(response.data); // Kullanıcı bilgilerini güncelle
        onHide();
      })
      .catch((axiosError) => {
        console.log(axiosError);
        if (
          axiosError.response?.data &&
          axiosError.response.data.status === 400
        ) {
          setErrors(axiosError.response.data.validationErrors);
        } else {
          setGeneralError("Unexpected error occured.Please try again.");
        }
        setAuthHeader(null);
      })
      .finally(() => {
        // setApiProgress(false);
      });
  };

  return (
    <Modal show={show} onHide={onHide} centered>
      <Modal.Header closeButton>
        <Modal.Title>Login</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Input
            id="username"
            labelName="Username"
            type="text"
            onChange={onChangeUsername}
            error={errors.username}
            value={username}
          />
          <Input
            id="password"
            labelName="Password"
            type="password"
            onChange={onChangePassword}
            error={errors.password}
            value={password}
          />
        </Form>
        {generalError && (
          <Alert className="mt-5" variant="danger">
            {generalError}
          </Alert>
        )}
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
