import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useState } from "react";
import { Button, Form, FormGroup, InputGroup } from "react-bootstrap";

const Input = ({ id, labelName, type, onChange, error, value }) => {
  const [showPassword, setShowPassword] = useState(false);
  const togglePasswordVisibility = () => {
    setShowPassword((prevShowPassword) => !prevShowPassword);
  };
  return (
    <FormGroup className="mt-2">
      <Form.Label>{labelName}</Form.Label>
      <InputGroup controlid={id}>
        {type === "password" ? (
          <Form.Control
            type={showPassword ? "text" : "password"}
            placeholder={`Enter ${labelName}`}
            onChange={onChange}
            value={value}
            required
            className={error && "is-invalid"}
          />
        ) : (
          <Form.Control
            type={type}
            placeholder={`Enter ${labelName}`}
            onChange={onChange}
            value={value}
            required
            className={error && "is-invalid"}
          />
        )}
        {type === "password" && (
          <Button
            variant="outline-secondary"
            onClick={togglePasswordVisibility}
          >
            <FontAwesomeIcon icon={showPassword ? faEye : faEyeSlash} />
          </Button>
        )}
        <Form.Control.Feedback type="invalid">{error}</Form.Control.Feedback>
      </InputGroup>
    </FormGroup>
  );
};
export default Input;
