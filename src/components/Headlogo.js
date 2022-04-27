/* eslint-disable jsx-a11y/alt-text */
import React from "react";
import image3 from "../images/Group 20399.svg";
import image4 from "../images/logo.svg.svg";

const Headlogo = () => {
  return (
    <div style={{ padding: "10px 3px", height: "70px" }} className="logo-hrc">
      <img
        style={{ display: "flex", height: "50px", float: "left" }}
        src={image3}
      />
      <img
        style={{
          display: "inline-block",
          height: "50px",
          marginRight: "210px",
        }}
        src={image4}
      />
    </div>
  );
};

export default Headlogo;
