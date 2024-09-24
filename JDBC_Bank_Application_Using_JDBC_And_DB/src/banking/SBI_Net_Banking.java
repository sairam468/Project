package banking;

import java.sql.*;
import java.util.Scanner;

public class SBI_Net_Banking {

	static Scanner sc=new Scanner(System.in);

	private void operation(){
		try {

			do {
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sai","1234");

				PreparedStatement ps1=con.prepareStatement("select * from bankappuser where  USERNAME=? AND  USERPASSWORD=?");
				PreparedStatement ps2=con.prepareStatement("update bankappuser set ACCOUNTBALANCE=ACCOUNTBALANCE+? where ACCOUNTNUMBER=?");

				PreparedStatement ps3=con.prepareStatement("insert into bankappuser values(?,?,?,?,?,?)");
				PreparedStatement ps4=con.prepareStatement("select * from bankappuser");
				PreparedStatement ps5=con.prepareStatement("update bankappuser set USERNAME=?,USERPASSWORD=? where ACCOUNTNUMBER=?");
				PreparedStatement ps6=con.prepareStatement("delete bankappuser where ACCOUNTNUMBER=?");

				PreparedStatement ps7=con.prepareStatement("select * from bankappuser where  ACCOUNTNUMBER=?");
				PreparedStatement ps8=con.prepareStatement("select * from bankappadmin where  USERNAME=? AND  PASSWORD=?");


				System.out.println("***Welcome to SBI Net Banking***");

				System.out.println("\n======================================");
				System.out.println("Enter Login Type : ");
				System.out.println("1.)---User Login---");
				System.out.println("2.)--Admin login--");
				System.out.println("3.)--Exit--");
				System.out.println("Choose one :)");
				System.out.println("======================================");
				int loginType=sc.nextInt();

				if(loginType==1) {
					System.out.println("\n======================================");
					System.out.println("---Enter the User Login Credentials---");
					System.out.println("Enter Username : ");
					String userName=sc.next();
					System.out.println("Enter UserPassword : ");
					String userPass=sc.next();
					System.out.println("======================================");

					ps1.setString(1, userName);
					ps1.setString(2, userPass);
					ResultSet rs1=ps1.executeQuery();

					boolean f=true;

					if(rs1.next()  && f) {
						System.out.println("\nLogin Sucessfull");
						System.out.println("you are Viewing "+rs1.getString(1)+"'s page");


						while(f) {
							System.out.println("\n***********************************");
							System.out.println("----Choose an operation---");
							System.out.println("1.)View account Details");
							System.out.println("2.)View account balance");
							System.out.println("3.)Deposit Money");
							System.out.println("4.)WithDraw Money");
							System.out.println("5.)Send Money");
							System.out.println("6.)Logout");
							System.out.println("7.)Exit");
							System.out.println("***********************************\n");

							int choice=sc.nextInt();
							switch(choice) {

							case 1:
								ps7.setLong(1, rs1.getLong(2));
								ResultSet rss=ps7.executeQuery();
								if(rss.next())
									System.out.println("....account details....");
								System.out.println(rss.getString(1)+"\t"+rss.getLong(2)+"\t"+rss.getDouble(3)+"\t"+rss.getString(4)+"\t"+rss.getString(5)+"\t"+rss.getString(6));
								break;
							case 2:
								System.out.println("Your Account Balance is : "+rs1.getDouble(3));
								break;

							case 3:
								System.out.println("Enter The Amount to be Depositted in your account : ");
								con.setAutoCommit(false);
								Savepoint sv=con.setSavepoint();
								double amt=sc.nextDouble();
								long accNum=rs1.getLong(2);
								ps2.setDouble(1, amt);
								ps2.setLong(2, accNum);

								int k=ps2.executeUpdate();
								if(k==1) {
									System.out.println("Your Transaction Sucessfull..");
									con.commit();
									System.out.println("Updated balance :(Y/N)");
									char c=sc.next().toLowerCase().charAt(0);
									if(c=='y') {
										ps7.setLong(1, accNum);
										ResultSet rs2=ps7.executeQuery();
										rs2.next();
										System.out.println("Your Updated Bank balance is : "+rs2.getDouble(3));
									}

								}
								else {
									System.out.println("Your Transaction Unsucessfull!");
									con.rollback(sv);	
								}

								break;

							case 4:
								System.out.println("Enter The Amount to be Creditted from your account : ");
								con.setAutoCommit(false);
								Savepoint sv3=con.setSavepoint();
								double amt3=sc.nextDouble();
								long accNum3=rs1.getLong(2);

								if(amt3<=rs1.getDouble(3)) {
									ps2.setDouble(1, -amt3);
									ps2.setLong(2, accNum3);

									int i=ps2.executeUpdate();
									if(i==1) {
										System.out.println("Your Transaction Sucessfull..");
										con.commit();
										System.out.println("Updated balance :(Y/N)");
										char c=sc.next().toLowerCase().charAt(0);
										if(c=='y') {
											ps7.setLong(1, accNum3);
											ResultSet rs2=ps7.executeQuery();
											rs2.next();
											System.out.println("Your Updated Bank balance is : "+rs2.getDouble(3));
										}
									}
									else {
										System.out.println("Your Transaction Unsucessfull!");
										con.rollback(sv3);	
									}

								}
								else {
									System.out.println("Insufficient balance!");
								}

								break;

							case 5:
								con.setAutoCommit(false);
								Savepoint sv4=con.setSavepoint();	

								long hAccNo=rs1.getLong(2);
								ps7.setLong(1, hAccNo);
								ResultSet rs4=ps7.executeQuery();
								if(rs4.next()) {
									double hAccBal=rs4.getDouble(3);
									System.out.println("Enter beneficary Account Number :");
									long bAccNo=sc.nextLong();
									ps7.setLong(1, bAccNo);
									ResultSet rs2=ps7.executeQuery();
									if(rs2.next()) {
										System.out.println("Enter the Amount :");
										long Amt=sc.nextLong();
										if(Amt<=hAccBal) {
											ps2.setLong(1, -Amt);
											ps2.setLong(2, hAccNo);
											int i=ps2.executeUpdate();

											ps2.setLong(1, Amt);
											ps2.setLong(2, bAccNo);
											int j=ps2.executeUpdate();

											if(i==1 && j==1) {
												System.out.println("Your Transaction Sucessful :) ...");
												con.commit();
												System.out.println("Updated balance :(Y/N)");
												char c=sc.next().toLowerCase().charAt(0);
												if(c=='y') {
													ps7.setLong(1, hAccNo);
													ResultSet rs5=ps7.executeQuery();
													rs5.next();
													System.out.println("Your Updated Bank balance is : "+rs5.getDouble(3));
												}

											}
											else {
												System.out.println("Your Transaction failed :( ...");
												con.rollback(sv4);
											}
										}
									}
									else {
										System.out.println("Invalid BAccNo .....");
									}
								}
								else {
									System.out.println("Invalid HAccNo .....");
								}



								break;

							case 6:
								System.out.println("Logging out...");
								System.out.println("You are going back to login Menu \n");
								f=false;
								break;

							case 7:
								System.out.println("Operations Ended....");
								System.exit(0);
								break;

							default:
								System.out.println("Invalid Operation Selected...");
								break;	

							}
						}
					}
					else {
						System.out.println("Invalid Credentials");
					}

				}
				else if(loginType==2) {

					System.out.println("\n======================================");
					System.out.println("--Enter the Admin login Credentials--");
					System.out.println("Enter Username : ");
					String adminName=sc.next();
					System.out.println("Enter UserPassword : ");
					String adminPass=sc.next();
					System.out.println("======================================");

					ps8.setString(1, adminName);
					ps8.setString(2, adminPass);
					ResultSet rs1=ps8.executeQuery();

					boolean f=true;
					if(rs1.next() && f) {
						System.out.println("\nLogin Sucessfull");
						System.out.println("you are Viewing "+rs1.getString(1)+"'s page");

						while(f) {
							System.out.println("\n***********************************");
							System.out.println("----Choose an operation---");
							System.out.println("1.)Create an Account");
							System.out.println("2.)View All Accounts");
							System.out.println("3.)Change Account Username And Password");
							System.out.println("4.)Delete an Account");
							System.out.println("5.)Logout");
							System.out.println("6.)Exit");
							System.out.println("***********************************\n");

							int choice=sc.nextInt();

							switch(choice) {
							case 1:
								System.out.println("Enter your full Name : ");
								String n = sc.nextLine();
		
								System.out.println("Enter the Account Number : ");
								long an = Long.parseLong(sc.nextLine());
								sc.nextLine(); // Consume newline left-over

								System.out.println("Enter the Account balance : ");
								double bal = Double.parseDouble(sc.nextLine());
								sc.nextLine(); // Consume newline left-over

								System.out.println("Enter your Account UserName : ");
								String aun = sc.nextLine();

								System.out.println("Enter your Account User Password: ");
								String aup = sc.nextLine();

								System.out.println("Enter Your account type : ");
								String at = sc.next();
								sc.nextLine(); // Consume newline left-over (if needed)


								
								//Lines skipping here and down update also
								

								ps3.setString(1,n);
								ps3.setLong(2, an);
								ps3.setDouble(3, bal);
								ps3.setString(4, at);
								ps3.setString(5, aun);
								ps3.setString(6, aup);

								int i=ps3.executeUpdate();
								if(i>0) {
									System.out.println("Account created sucessfully...");
								}
								else {
									System.out.println("Invalid password...");
								}

								break;

							case 2:
								System.out.println("All Accounts are : ");
								ResultSet rs=ps4.executeQuery();
								while(rs.next()) {
									System.out.println(rs.getString(1)+"\t"+rs.getLong(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));

								}

								break;

							case 3:
								System.out.println("--Update Account Username And Password--");

								System.out.println("Enter Account number : ");
								long acno= Long.parseLong(sc.nextLine());
								sc.nextLine();
								System.out.println("Enter New Account UserName : ");
								String naun=sc.nextLine();
								System.out.println("Enter New Account User Password: ");
								String naup=sc.nextLine();

								ps5.setString(1, naun);
								ps5.setString(2, naup);
								ps5.setLong(3,acno);

								int j=ps5.executeUpdate();
								if(j>0) {
									System.out.println("Data updated Sucessfully");
								}
								else {
									System.out.println("Invalid password...");
								}

								break;

							case 4:
								System.out.println("--Deleting Account--");

								System.out.println("Enter Account number : ");
								long acn=sc.nextLong();
								
								ps6.setLong(1, acn);
								int k=ps6.executeUpdate();
								if(k>0) {
									System.out.println("Account deleted sucessfully...");
								}

								break;	

							case 5:
								System.out.println("Logging out...");
								System.out.println("You are going back to login Menu \n");
								f=false;
								break;
								
							case 6:
								System.out.println("Operations Ended....");
								System.exit(0);
								break;	

							default:
								System.out.println("Invalid Operation Selected...");
								break;	

							}
						}

					}
					else {
						System.out.println("Invalid Credentials");
					}

				}
				else if(loginType==3) {
					System.out.println("Operations Ended....");
					System.exit(0);
				}


				else {
					System.out.println("Invalid login option...");
				}
				con.close();
			}
			while(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new SBI_Net_Banking().operation();
		sc.close();
	}
}
