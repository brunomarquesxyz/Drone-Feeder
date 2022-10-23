import { Box } from "@mui/material";
import React from "react";

interface Props {
  children?: React.ReactNode;
}

const Main: React.FC<Props> = ({ children }) => {
  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "82vh",
        width: "100%",
        backgroundColor: "primary.main",
        color: "primary.contrastText",
      }}
    >
      {children}
    </Box>
  );
};

export default Main;
