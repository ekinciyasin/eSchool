import Header from "./components/Header";
import Footer from "./components/Footer";
import "./App.css";
import HeaderMenu from "./components/HeaderMenu";
import { useUser } from "./context/UserContext";
import StudentTools from "./pages/student/components/StudentTools";
import { Outlet, useLocation } from "react-router-dom";
import React from "react";

function App() {
  const location = useLocation();
  const { user, isLoggedIn } = useUser();

  const isHomePage = location.pathname === "/";

  return (
    <div className="app">
      <HeaderMenu />
      {!isLoggedIn && isHomePage && <Header />}
      {user?.roles.includes("ROLE_STUDENT") && isHomePage && <StudentTools />}
      <Outlet />
      <Footer />
    </div>
  );
}

export default App;
