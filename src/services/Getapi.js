import axios from "axios";

let Getapi = ({ setData }) => {
  const url = "http://localhost:8080/backend/Fetch";
  axios.get(url).then((res) => {
    setData(res.data);
  });
};

export default Getapi;
