import { Box, Typography } from "@mui/material";
import React from "react";

// import { Container } from './styles';

const Footer: React.FC = () => {
  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#d6d8e2",
        height: "3vh",
        width: "100%",
      }}
    >
      <Typography>Created by: Bruno Marques e Thauler Mayrink</Typography>
    </Box>
  );
};

export default Footer;
