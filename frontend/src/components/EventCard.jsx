import React from "react";
import "./EventCard.css";
import reactImg from "../assets/images/concert.jpeg";

const EventCard = ({ title, description, date, image }) => {
  return (
    <div className="event-card">
      <img src={image} alt="Concert" />

      <div className="event-details">
        <h3>{title}</h3>
        <p className="date">{date}</p>
        <p className="description">{description}</p>
      </div>
    </div>
  );
};

export default EventCard;
