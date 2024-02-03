import React, { useState, useEffect } from "react";
import { OverlayTrigger, Table, Tooltip } from "react-bootstrap";
import { getStudentGrades } from "../../../services/axios_helper";

const GradeTableForStudent = () => {
  const [grades, setGrades] = useState([]);

  useEffect(() => {
    // Axios ile backend'e istek gönderme
    getStudentGrades() // BACKEND_API_URL'i kendi backend URL'inizle değiştirin
      .then((response) => {
        setGrades(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching student grades:", error);
      });
  }, []); // Boş dependency array ile sadece bir kere yüklenmesini sağlayın

  const renderTableData = () => {
    const lessons = {};

    if (!Array.isArray(grades)) {
      console.error("Grades is not an array:", grades);
      return null;
    }
    // Dersleri ve notları ayrı ayrı nesnelere yerleştirme
    grades.forEach((grade) => {
      if (grade.lesson) {
        const lessonId = grade.lesson.id;
        const lessonName = grade.lesson.name;
        const gradeValue =
          grade.gradeValue !== -1 ? grade.gradeValue : "Not Yok";
        const examDate = grade.exam ? grade.exam.localDate : null;

        if (!lessons[lessonId]) {
          lessons[lessonId] = {
            name: lessonName,
            values: [gradeValue],
            examDates: [examDate],
          };
        } else {
          lessons[lessonId].values.push(gradeValue);
        }
      }
    });

    // Tabloyu oluşturma
    return Object.keys(lessons).map((lessonId) => (
      <tr key={lessonId}>
        <td>{lessons[lessonId].name}</td>

        {[...Array(5)].map((_, columnIndex) => (
          <OverlayTrigger
            key={columnIndex}
            placement="top"
            overlay={
              <Tooltip>{lessons[lessonId].examDates[columnIndex]}</Tooltip>
            }
          >
            <td key={columnIndex} className="text-center">
              {lessons[lessonId].values[columnIndex] !== undefined
                ? lessons[lessonId].values[columnIndex]
                : "-"}
            </td>
          </OverlayTrigger>
        ))}
      </tr>
    ));
  };

  return (
    <div className="m-3">
      <h2 className="text-center">Student Grades</h2>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Dersler</th>
            {[...Array(5)].map((_, index) => (
              <th className="text-center" key={index}>
                Not {index + 1}
              </th>
            ))}
          </tr>
        </thead>
        <tbody>{renderTableData()}</tbody>
      </Table>
    </div>
  );
};

export default GradeTableForStudent;
