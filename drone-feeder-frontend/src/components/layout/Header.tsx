import { Typography } from "@mui/material";
import { Box } from "@mui/system";
import React from "react";

const Header: React.FC = (props: any) => {
  return (
    <header>
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "15vh",
          width: "100%",
          backgroundColor: "primary.main",
          color: "primary.contrastText",
        }}
      >
        <Typography variant="h2">Drone Feeder</Typography>
      </Box>
    </header>
  );
};

export default Header;
