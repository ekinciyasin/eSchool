import React from "react";
import EventCard from "./EventCard";
import "./EventList.css";
import reactImg from "../assets/images/concert.jpeg";
const dummyEvents = [
  {
    title: "School Concert",
    description:
      "Experience an enchanting evening filled with melodies and artistic brilliance at our School Concert scheduled for November 15, 2023. Join us for a delightful showcase featuring the extraordinary musical talents of our students. From soulful melodies to lively performances, our talented students will captivate your hearts and leave you with cherished memories. It's a celebration of creativity, unity, and the power of music. Save the date for this remarkable event that promises an unforgettable journey through the world of captivating tunes and exceptional performances. We look forward to sharing this musical extravaganza with you.",
    date: "November 15, 2023",
    image: reactImg, // Dummy image URL
  },
  {
    title: "Mathematics Olympiad",
    description:
      "Experience the extraordinary showcase of our students' mathematical prowess at the annual Mathematics Olympiad competition on December 3, 2023. This prestigious event promises to unveil the brilliance of young minds as they engage in challenging mathematical challenges and problem-solving. Join us in celebrating the passion for mathematics and the exceptional talents of our participants. Don't miss the chance to witness a captivating display of intellect and creativity in the world of mathematics on this remarkable day. Mark your calendars for an unforgettable mathematical journey!",
    date: "December 3, 2023",
    image: "https://placekitten.com/800/401", // Dummy image URL
  },
  // Add more dummy events as needed
];

const EventList = () => {
  return (
    <div className="event-list">
      {dummyEvents.map((event, index) => (
        <EventCard key={index} {...event} />
      ))}
    </div>
  );
};

export default EventList;
