import React from "react";
import { Link } from "react-router-dom";

function SubmitForm() {
  const handleSubmit = (event) => {
    event.preventDefault();

    const name = event.target.name.value;
    const email = event.target.email.value;

    console.log(name);
    console.log(email);
  };

  return (
    <div className="min-h-screen flex justify-center items-center bg-gray-100">
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded shadow-md w-96"
      >
        <h1 className="text-2xl font-bold mb-4">Submit Form</h1>

        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          className="border w-full p-2 mb-4"
        />

        <input
          type="email"
          name="email"
          placeholder="Enter Email"
          className="border w-full p-2 mb-4"
        />

        <button
          type="submit"
          className="bg-blue-600 text-white px-4 py-2 rounded w-full"
        >
          Submit
        </button>

        <Link
          to="/feedback"
          className="block text-center text-blue-600 mt-4"
        >
          Go to Feedback Form
        </Link>
      </form>
    </div>
  );
}

export default SubmitForm;