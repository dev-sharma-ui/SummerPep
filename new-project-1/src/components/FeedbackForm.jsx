import React from "react";
import { Link } from "react-router-dom";

function FeedbackForm() {
  const handleSubmit = (event) => {
    event.preventDefault();

    const username = event.target.username.value;
    const feedback = event.target.feedback.value;

    console.log(username);
    console.log(feedback);
  };

  return (
    <div className="min-h-screen flex justify-center items-center bg-gray-100">
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded shadow-md w-96"
      >
        <h1 className="text-2xl font-bold mb-4">Feedback Form</h1>

        <input
          type="text"
          name="username"
          placeholder="Enter Username"
          className="border w-full p-2 mb-4"
        />

        <textarea
          name="feedback"
          placeholder="Enter Feedback"
          className="border w-full p-2 mb-4"
        ></textarea>

        <button
          type="submit"
          className="bg-green-600 text-white px-4 py-2 rounded w-full"
        >
          Send Feedback
        </button>

        <Link
          to="/"
          className="block text-center text-blue-600 mt-4"
        >
          Back to Submit Form
        </Link>
      </form>
    </div>
  );
}

export default FeedbackForm;