import React, { useState } from "react";
import { Card, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

const ClickableCard = ({ title, description, onClick }) => {
  const [isHovered, setIsHovered] = useState(false);
  const cardStyle = {
    cursor: "pointer",
    boxShadow: isHovered
      ? "0 0 15px rgba(49, 43, 231, 0.8)"
      : "0 0 10px rgba(44, 43, 43, 0.5)",
    padding: "3px", // Küçük bir padding
    margin: "2px",
    height: "100%",
    backgroundColor: isHovered ? "#e9ecef" : "#f8f9fa",
  };
  const headerStyle = {
    fontWeight: "bold", // Kalın başlık
  };

  return (
    <Col>
      <Link to="/grades" style={{ textDecoration: "none" }}>
        <Card
          bg="secondary"
          className="mb-2 clickable-card"
          style={{ ...cardStyle }}
          onClick={onClick}
          onMouseOver={() => setIsHovered(true)}
          onMouseOut={() => setIsHovered(false)}
        >
          <Card.Body>
            <Card.Title style={headerStyle}>{title}</Card.Title>
            <Card.Text>{description}</Card.Text>
          </Card.Body>
        </Card>
      </Link>
    </Col>
  );
};

export default ClickableCard;
