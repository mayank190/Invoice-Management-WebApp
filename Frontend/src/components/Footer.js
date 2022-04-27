import React from "react";
import { year } from "./vars";

function Footer() {
  return (
    <div className="footer">
      <a href="https://www.highradius.com/privacy-policy/">Privacy Policy</a>| @
      {year} Highradius Corporation. All rights reserved.
    </div>
  );
}

export default Footer;
