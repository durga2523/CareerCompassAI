import { useState } from "react";
import { useNavigate } from "react-router-dom";
import authContent from "../data/authContent";
import "../styles/auth.css";
import { registerUser } from "../services/authService";

function Register() {

    const navigate = useNavigate();

    const [fullName, setFullName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);

    const [errors, setErrors] = useState({});
    const [loading, setLoading] = useState(false);

    const handleKeyDown = (e) => {
        if (e.key === "Enter") {
            handleRegister();
        }
    };

    const handleRegister = async () => {

        if (loading) return;

        setErrors({});

        if (!fullName || !email || !password || !confirmPassword) {
            setErrors({
                general: "Please fill all fields."
            });
            return;
        }

        if (password !== confirmPassword) {
            setErrors({
                confirmPassword: "Passwords do not match."
            });
            return;
        }

        const fullNameRegex = /^[A-Za-z ]+$/;

        if (!fullNameRegex.test(fullName.trim())) {
            setErrors({
                fullName: "Please enter a valid full name."
            });
            return;
        }

        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailRegex.test(email)) {
            setErrors({
                email: "Please enter a valid email address."
            });
            return;
        }

        try {

            setLoading(true);

            await registerUser({
                fullName,
                email,
                password
            });

            setErrors({
                success: "Registration Successful! Redirecting to Login..."
            });

            setLoading(false);

            setTimeout(() => {
                navigate("/");
            }, 1500);

        } catch (error) {

            setLoading(false);

            if (typeof error.response?.data === "string") {

                setErrors({
                    email: error.response.data
                });

                return;
            }

            if (error.response?.data) {

                setErrors(error.response.data);

                return;
            }

            setErrors({
                general: "Registration failed."
            });

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

                <h2>{authContent.registerTitle}</h2>

                <p className="subtitle">
                    {authContent.registerSubtitle}
                </p>

                {errors.success && (
                    <small className="field-success">
                        {errors.success}
                    </small>
                )}

                {errors.general && (
                    <small className="field-error">
                        {errors.general}
                    </small>
                )}

                <div className="form-group">

                    <label>Full Name</label>

                    <input
                        autoFocus
                        type="text"
                        value={fullName}
                        onChange={(e) => setFullName(e.target.value)}
                        onKeyDown={handleKeyDown}
                        placeholder="Enter your full name"
                    />

                    {errors.fullName && (
                        <small className="field-error">
                            {errors.fullName}
                        </small>
                    )}

                </div>

                <div className="form-group">

                    <label>{authContent.email}</label>

                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        onKeyDown={handleKeyDown}
                        placeholder="Enter your email"
                    />

                    {errors.email && (
                        <small className="field-error">
                            {errors.email}
                        </small>
                    )}

                </div>

                <div className="form-group">

                    <label>{authContent.password}</label>

                    <div className="password-wrapper">

                        <input
                            type={showPassword ? "text" : "password"}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            onKeyDown={handleKeyDown}
                            placeholder="Create a password"
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

                    <small className="field-hint">
                        Password must contain at least 6 characters.
                    </small>

                    {errors.password && (
                        <small className="field-error">
                            {errors.password}
                        </small>
                    )}

                </div>

                <div className="form-group">

                    <label>{authContent.confirmPassword}</label>

                    <div className="password-wrapper">

                        <input
                            type={
                                showConfirmPassword
                                    ? "text"
                                    : "password"
                            }
                            value={confirmPassword}
                            onChange={(e) =>
                                setConfirmPassword(e.target.value)
                            }
                            onKeyDown={handleKeyDown}
                            placeholder="Confirm your password"
                        />

                        <span
                            className="toggle-password"
                            onClick={() =>
                                setShowConfirmPassword(
                                    !showConfirmPassword
                                )
                            }
                        >
                            <i
                                className={`bi ${
                                    showConfirmPassword
                                        ? "bi-eye-slash"
                                        : "bi-eye"
                                }`}
                            ></i>
                        </span>

                    </div>

                    {errors.confirmPassword && (
                        <small className="field-error">
                            {errors.confirmPassword}
                        </small>
                    )}

                </div>

                <button
                    className="auth-button"
                    onClick={handleRegister}
                    disabled={loading}
                >

                    {loading ? (

                        <>
                            <span
                                className="spinner-border spinner-border-sm me-2"
                                role="status"
                                aria-hidden="true"
                            ></span>

                            Creating Account...

                        </>

                    ) : (

                        authContent.register

                    )}

                </button>

                <p className="switch-page">

                    {authContent.alreadyAccount}{" "}

                    <span onClick={() => navigate("/")}>
                        Login
                    </span>

                </p>

            </div>

        </div>

    );

}

export default Register;