import { NextPage } from "next";
import Head from "next/head";
import React from "react";
import Footer from "./Footer";
import Header from "./Header";
import LeftMenu from "./LeftMenu";
import Main from "./Main";

interface Props {
  children?: React.ReactNode;
}

const Layout: NextPage<Props> = ({ children }) => {
  return (
    <React.Fragment>
      <Header />
      <LeftMenu />
      <Main>{children}</Main>
      <Footer />
    </React.Fragment>
  );
};

export default Layout;
