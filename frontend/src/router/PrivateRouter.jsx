import { Route, Navigate, Link } from "react-router-dom";
import { useUser } from "../context/UserContext";

const PrivateRoute = ({ component: Component, allowedRoles, ...rest }) => {
  const { isLoggedIn } = useUser();
  console.log(isLoggedIn);

  if (!isLoggedIn) {
    return (
      <div>
        <p>You need to be logged in to access this page.</p>
        <Link to="/">Go to homepage</Link>
      </div>
    );
  }

  return (
    <Component
      {...this.props}
      // Bu satır, "useUser" bileşenini kullanarak kullanıcının kimlik doğrulama durumunu kontrol eder.
      isLoggedIn={isLoggedIn}
    />
  );
};

export default PrivateRoute;
