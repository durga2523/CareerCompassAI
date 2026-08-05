import { useState } from "react";
import { loginUser } from "../services/authService";
import { useNavigate } from "react-router-dom";
import authContent from "../data/authContent";
import "../styles/auth.css";
import Message from "../components/Message";

function Login() {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [showPassword, setShowPassword] = useState(false);
    const [loading, setLoading] = useState(false);


    const [message, setMessage] = useState("");
    const [messageType, setMessageType] = useState("");

    const handleLogin = async () => {

        if (loading) return;

        setMessage("");
        setMessageType("");

        if (!email || !password) {

            setMessage("Please enter both email and password.");
            setMessageType("error");
            return;

        }

        try {

            setLoading(true);

            const response = await loginUser({
                email,
                password
            });

            localStorage.setItem("token", response.token);
            localStorage.setItem("userId", response.userId);

            setMessage("Login Successful!");
            setMessageType("success");

            setLoading(false);

            navigate("/dashboard");

        } catch (error) {

            console.error(error);

            setMessage("Invalid email or password.");
            setMessageType("error");

            setLoading(false);

        }

    };

    const handleKeyDown = (e) => {

        if (e.key === "Enter") {
            handleLogin();
        }

    };

    return (

        <div className="auth-page">

            <div className="auth-left">

                <h1 className="logo">
                    {authContent.appName}
                </h1>

                <p className="tagline">
                    AI Powered Resume Analysis Platform
                </p>

            </div>

            <div className="auth-right">

                <h2>{authContent.loginTitle}</h2>

                <p className="subtitle">
                    {authContent.loginSubtitle}
                </p>

                <Message
                    type={messageType}
                    text={message}
                />

                <div className="form-group">

                    <label>{authContent.email}</label>

                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        onKeyDown={handleKeyDown}
                        placeholder="Enter your email"
                    />

                </div>

                <div className="form-group">

                    <label>{authContent.password}</label>

                    <div className="password-wrapper">

                        <input
                            type={showPassword ? "text" : "password"}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            onKeyDown={handleKeyDown}
                            placeholder="Enter your password"
                        />

                        <span
                            className="toggle-password"
                            onClick={() => setShowPassword(!showPassword)}
                        >
                            <i
                                className={`bi ${
                                    showPassword
                                        ? "bi-eye-slash"
                                        : "bi-eye"
                                }`}
                            ></i>
                        </span>

                    </div>

                </div>

                <button
                    className="auth-button"
                    onClick={handleLogin}
                    disabled={loading}
                >

                    {loading ? (

                        <>

                            <span
                                className="spinner-border spinner-border-sm me-2"
                                role="status"
                            ></span>

                            Signing In...

                        </>

                    ) : (

                        authContent.login

                    )}

                </button>

                <p className="switch-page">

                    {authContent.noAccount}{" "}

                    <span onClick={() => navigate("/register")}>
                        Register
                    </span>

                </p>

            </div>

        </div>

    );

}

export default Login;