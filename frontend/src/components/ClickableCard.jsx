import React from "react";
import { Card } from "react-bootstrap";

const ClickableCard = ({ title, description, onClick }) => {
  const cardStyle = {
    cursor: "pointer",
    boxShadow: "0 0 10px rgba(0, 0, 0, 0.5)", // Hafif gölge
    padding: "10px", // Küçük bir padding
    margin: "5px",
    backgroundColor: "#f8f9fa", // Gri arkaplan
  };
  const headerStyle = {
    fontWeight: "bold", // Kalın başlık
  };
  return (
    <Card bg="secondary" className="mb-2" style={cardStyle} onClick={onClick}>
      <Card.Body>
        <Card.Title style={headerStyle}>{title}</Card.Title>
        <Card.Text>{description}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default ClickableCard;
