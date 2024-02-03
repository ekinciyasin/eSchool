import React, { useState } from "react";
import { Navbar, Nav, Button } from "react-bootstrap";
import Container from "react-bootstrap/Container";
import "./HeaderMenu.css"; // Import your styles
import LoginModal from "../pages/Login/index";
import Form from "react-bootstrap/Form";
import logo from "../assets/images/logo.jpeg";
import { useUser } from "../context/UserContext";
import { useNavigate } from "react-router-dom";

function HeaderMenu() {
  const navigate = useNavigate();
  const [showLoginModal, setShowLoginModal] = useState(false);
  const { user, isLoggedIn, logoutUser } = useUser();

  const handleLoginButtonClick = () => {
    setShowLoginModal(true);
  };

  const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/");
    logoutUser();
    localStorage.clear();
  };

  return (
    <>
      <Navbar className="bg-body-tertiary" bg="primary" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">
            <img
              alt=""
              src={logo}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{" "}
            E-School
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#news">News</Nav.Link>
            <Nav.Link href="#events">Events</Nav.Link>
            <Nav.Link href="#calendar">Calendar</Nav.Link>
            <Nav.Link href="#about">About us</Nav.Link>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-primary">Search</Button>
          </Form>
          <Nav className="ml-auto">
            {isLoggedIn ? (
              <>
                <Nav.Link>
                  Welcome, {user.firstName} {user.lastName}
                </Nav.Link>
                <Nav>
                  <Button
                    className="ms-3"
                    variant="secondary"
                    onClick={handleLogout}
                  >
                    Logout
                  </Button>
                </Nav>
              </>
            ) : (
              <Nav>
                <Button
                  className="ms-3"
                  variant="primary"
                  onClick={handleLoginButtonClick}
                >
                  Login
                </Button>
              </Nav>
            )}
          </Nav>
        </Container>
      </Navbar>

      <LoginModal
        show={showLoginModal}
        onHide={() => setShowLoginModal(false)}
      />
    </>
  );
}

export default HeaderMenu;
