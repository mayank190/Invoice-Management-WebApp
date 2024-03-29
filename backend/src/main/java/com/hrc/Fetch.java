package com.hrc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.google.gson.Gson;
import com.pojo.pojo;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			Connection conn=Create_Connection.cc();
			Statement st=conn.createStatement();  
			//PreparedStatement pre_st= conn.prepareStatement(sql);
			String query="SELECT * FROM winter_internship where is_deleted=0 limit 10";
			ResultSet rs=st.executeQuery(query);  // ResultSet me saari queries aachuki hai abth
			ArrayList<pojo> fetcheddata= new ArrayList<pojo>();
			
			while(rs.next()) {  
				// Jabtk iterate kro t=jbtk  resultset empty nhi hojata
				pojo take=new pojo();
				take.setSl_no(rs.getString("sl_no"));
				take.setBusiness_code(rs.getString("business_code"));
				take.setCust_number(rs.getString("cust_number"));
				take.setClear_date(rs.getString("clear_date"));
				take.setBuisness_year(rs.getString("buisness_year"));
				take.setDoc_id(rs.getString("doc_id"));
				take.setPosting_date(rs.getString("posting_date"));
				take.setDocument_create_date(rs.getString("Document_create_date"));
				take.setDocument_create_date1(rs.getString("document_create_date1"));
				take.setDue_in_date(rs.getString("due_in_date"));
				take.setInvoice_currency(rs.getString("invoice_currency"));
				take.setDocument_type(rs.getString("document_type"));
				take.setPosting_id(rs.getString("posting_id"));
				take.setArea_business(rs.getString("area_business"));
				take.setTotal_open_amount(rs.getString("total_open_amount"));
				take.setBaseline_create_date(rs.getString("baseline_create_date"));
				take.setCust_payment_terms(rs.getString("cust_payment_terms"));
				take.setInvoice_id(rs.getString("invoice_id"));
				take.setIsOpen(rs.getString("isOpen"));
				take.setAging_bucket(rs.getString("aging_bucket"));
				fetcheddata.add(take);
			}
			
			// Gson ka kaam chalu  'Gson COnnector' Gson ka kaam bhota ha tera jo Json response hai  usko print krna Uske lie cconnector ADD EXTERNAL JAR me
//			Gson gson= new Gson();
			
			String rJ=new Gson().toJson(fetcheddata); // json format me repinse h usko string  me Rj me daalo 
			// ab hamar kaam h yhn  apni main screen pe print krne ka
			response.setContentType("application/json");
			response.getWriter().write(rJ);
					}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
