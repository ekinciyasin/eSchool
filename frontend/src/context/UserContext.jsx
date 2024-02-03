// src/context/UserContext.js
import { createContext, useContext, useState } from "react";

const UserContext = createContext();

export const useUser = () => {
  console.log(useContext(UserContext));
  return useContext(UserContext);
};

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const loginUser = (userData) => {
    setUser(userData);
    console.log(userData);
    setIsLoggedIn(true);
  };

  const logoutUser = () => {
    setUser(null);
    setIsLoggedIn(false);
  };

  return (
    <UserContext.Provider value={{ user, isLoggedIn, loginUser, logoutUser }}>
      {children}
    </UserContext.Provider>
  );
};
