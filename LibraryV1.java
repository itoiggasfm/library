import java.util.Scanner;

// manages creation, update, deletion of and sesrch about a library members
public class LibraryV1{
	public static void main(String args[]){
		//the capacity of library is declared as a constant. it'll help us change the capacity if neede only with changing the value of canstant variable
		System.out.println("\n-------------------------------------------\n"+
							"    The library accept only 10 members."+
							"\n-------------------------------------------\n");
							final int LIBRARY_CAPACITY = 10;
							//required arrays are declared to store user's identity profile		
							
							//  1. checks if there is a free space for new member
							boolean[] isMembersListEmptyArray = new boolean[LIBRARY_CAPACITY];
							
							// 2. stores members' names
							String[] memberNameArray = new String[LIBRARY_CAPACITY];
							
							// 3. stores members' family names
							String[] memberFamilyNameArray = new String[LIBRARY_CAPACITY];
							
							// 4. stores members' gender
							char[] memberGenderArray = new char[LIBRARY_CAPACITY];
							
							// 5. stores members' age
							int[] memberAgeArray = new int[LIBRARY_CAPACITY];
							
							Scanner input = new Scanner(System.in);
							
							String isProgramOpen = "open";
							
							//program opens
							programLoop: while(isProgramOpen == "open")
							{
								//prompts for user choice whether he wants to add a nember or do member affairs
								System.out.printf(
													"%n1) Add member"+
													"%n2) Members affairs"+
													"%n3) Exit the program"+
													"%nPlease enter a number between 1 and 3: ");
								String firstMenu = input.next();
								//checking the validity of user choice
								while(!(firstMenu.equalsIgnoreCase("1") || firstMenu.equalsIgnoreCase("2") || firstMenu.equalsIgnoreCase("3")))
								{
									System.out.printf(
														"%n1) Add member"+
														"%n2) Members affairs"+
														"%n3) Exit the program"+
														"%nPlease enter a number between 1 and 3: ");
									firstMenu = input.next();
								}
								
								// taking actions on the choice of user in that adding  a member or handling previous members				
								switch(Integer.parseInt(firstMenu))
								{
									// adding a member
									case 1:
									{
										// this block checks if there is free space for new membership
										int freePlace = LIBRARY_CAPACITY;
								
										for(int i=0; i<LIBRARY_CAPACITY; ++i)
										if(isMembersListEmptyArray[i] == true)
											--freePlace;
										if(freePlace == 0)
										{
											System.out.printf("%nWe're sorry to say that the the membership list of the lobrary is full at the moment and we can't accept a member.%n");
												continue programLoop;
										}
					
										// There is space for new member and enrollment process begins
										System.out.printf(
															"%n1) Enter new member profile"+
															"%n2) Back to previous menu"+
															"%n3) Exit the program"+
															"%nPlease enter a number between 1 and 3: ");
										String readyToBeMember = input.next();
										while(!(readyToBeMember.equalsIgnoreCase("1") || readyToBeMember.equalsIgnoreCase("2") || readyToBeMember.equalsIgnoreCase("3")))
										{
											System.out.printf(
																"%n1) Enter new member profile"+
																"%n2) Back to previous menu"+
																"%n3) Exit the program"+
																"%nPlease enter a number between 1 and 3: ");
											readyToBeMember = input.next();
										}
					
										switch(Integer.parseInt(readyToBeMember))
										{
											// new member identity profile are recieved
											case 1:
											{
												// find the first free place for member to save
												int placeID = 0;
												for(int i=0; i<LIBRARY_CAPACITY; ++i)
													if(isMembersListEmptyArray[i] == false)
													{
														isMembersListEmptyArray[i] = true;
														placeID = i;
														break;
													}
								
												// getting and saving member profile and then gets back to previous menu
												System.out.printf("Name: ");
												String memberName = input.next();
												memberNameArray[placeID] = memberName.substring(0 ,1).toUpperCase() + memberName.substring(1);
										
												System.out.printf("Family name: ");
												String memberFamilyName = input.next();
												memberFamilyNameArray[placeID] = memberFamilyName.substring(0 ,1).toUpperCase() + memberFamilyName.substring(1);
														
												System.out.printf("Gender((M)male, (F)female): ");
												char memberGender = input.next().charAt(0);
												while(!(memberGender == 'M' || memberGender == 'm' || memberGender == 'F' || memberGender == 'f'))
												{
													System.out.printf("Gender((M)male, (F)female): ");
													memberGender = input.next().charAt(0);
												}
												memberGenderArray[placeID] = Character.toUpperCase(memberGender);
						
												System.out.printf("Age: ");
												memberAgeArray[placeID] = input.nextInt();
							
												System.out.printf("%nMembership ID is: %d.%n", placeID+1);


												for(int i=0; i<LIBRARY_CAPACITY; ++i)
												{
													System.out.printf("%b, %s, %s, %c, %d",isMembersListEmptyArray[i], memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
															System.out.printf("%n");
												}
												continue programLoop;
											}
											 // end of case 1, getting user profile and saving 
											//break;
											
											//gets back to previous menu (add member or member affairs
											case 2:
											{
												continue programLoop;
											}
											//break;
											
											//first menu option 3: exit program
											case 3:
											{
												isProgramOpen = "closed";
												continue programLoop;
											}
										}
										// end of switch(Integer.parseInt(readyToBeMember)), getting member profile
									} 
									// end of case 1, option: add a member
									break;
				
									//first menu, option 2: member affairs
									case 2:
									{
										//first menu, option 2: member affairs
					membersAffairsLoop: while (Integer.parseInt(firstMenu) == 2)
										{
											// prompt for user to semect, checks tbe choice validity
										
											System.out.printf(
																"%n1) Search"+
																"%n2) Show member profile"+
																"%n3) Edit member profile"+
																"%n4) Delete member"+
																"%n5) Back to previous menu"+
																"%n6) Exit the program"+
																"%nPlease enter a number from 1 to 5: ");
											String membersAffairs = input.next();
											while(!(membersAffairs.equalsIgnoreCase("1") || membersAffairs.equalsIgnoreCase("2") || membersAffairs.equalsIgnoreCase("3") || membersAffairs.equalsIgnoreCase("4") || membersAffairs.equalsIgnoreCase("5") || membersAffairs.equalsIgnoreCase("6")))
											{
												System.out.printf(
																	"%n1) Search"+
																	"%n2) Show member profile"+
																	"%n3) Edit member profile"+
																	"%n4) Delete member"+
																	"%n5) Back to previous menu"+
																	"%n6) Exit the program"+
																	"%nPlease enter a number from 1 to 5: ");
											membersAffairs = input.next();
											}
											 
											// member affairs
											switch(Integer.parseInt(membersAffairs))
											{
												//searchs about members
												case 1:
												{
										searchLoop: while(Integer.parseInt(membersAffairs) == 1)
													{
														System.out.printf(
																			"%nSearch by:"+
																			"%n1) ID"+
																			"%n2) Name"+
																			"%n3) Family name"+
																			"%n4) Gender"+
																			"%n5) Age"+
																			"%n6) Back to previous menu"+
																			"%n7) Exit the program"+
																			"%nPlease enter a number from 1 to 7: ");
														String searchBy = input.next();
														while(!(searchBy.equalsIgnoreCase("1") || searchBy.equalsIgnoreCase("2") || searchBy.equalsIgnoreCase("3") || searchBy.equalsIgnoreCase("4") || searchBy.equalsIgnoreCase("5") || searchBy.equalsIgnoreCase("6") || searchBy.equalsIgnoreCase("7")))
														{
															System.out.printf(
																				"%nSearch by:"+
																				"%n1) ID"+
																				"%n2) Name"+
																				"%n3) Family name"+
																				"%n4) Gender"+
																				"%n5) Age"+
																				"%n6) Back to previous menu"+
																				"%n7) Exit the program"+
																				"%nPlease enter a number from 1 to 7: ");				
															searchBy = input.next();
														}
								
														//takes action on user's search chioce	
														switch(Integer.parseInt(searchBy))
														{
															//search by ID
															case 1:
															{
																System.out.printf("%nID: ");
																int searchID = input. nextInt();

																//Validity of search ID is ckecked and the previous profile is shown
																if(isMembersListEmptyArray[searchID-1] == true)
																	{
																		System.out.printf("%nID   Name          Family name   Gender   Age   ");
																		System.out.printf("%n------------------------------------------------");
																		System.out.printf("%n%-5s%-14s%-14s%-9c%-6d%n", searchID, memberNameArray[searchID-1], memberFamilyNameArray[searchID-1], memberGenderArray[searchID-1], memberAgeArray[searchID-1]);
																	}
																else
																	System.out.printf("%nID not found.%n");
															}
															//end of search by ID
															break;
															
															//search by name
															case 2:
															{
																System.out.printf(
																					"%nIncluding"+
																					"%n1) The whole name"+
																					"%n2) Part of the name"+
																					"%n3) Back to previous menu"+
																					"%n4) Exit the program"+
																					"%nPlease enter a number from 1 to 4: ");
																String subSearchName = input.next();
																while(!(subSearchName.equalsIgnoreCase("1") || subSearchName.equalsIgnoreCase("2") || subSearchName.equalsIgnoreCase("3") || subSearchName.equalsIgnoreCase("4")))
																{
																	System.out.printf(
																						"%nIncluding"+
																						"%n1) The whole name"+
																						"%n2) part of the name"+
																						"%n3) Back to previous menu"+
																						"%n4) Exit the program"+
																						"%nPlease enter a number from 1 to 4: ");
																	subSearchName = input.next();
																}
																
																switch(Integer.parseInt(subSearchName))
																{
																	// sesrch by full name
																	case 1:
																	{
																		System.out.printf("Name: ");
																		String searchName = input.next();
																
																		//checks if there is occurrances of name of search case. if so, counts.						
																		int counter=0;
																		for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		{
																			if(memberNameArray[i] == null)
																				continue;
																
																			if(memberNameArray[i].equalsIgnoreCase(searchName))
																				++counter;
																		}//end of counting name occurrances
															
																		//displays the occurances of age of search case found						
																		if(counter == 0)
																			System.out.printf("%nNothing found.%n");
																		else
																		{
																			System.out.printf("%nID   Name          Family name   Gender   Age   ");
																			System.out.printf("%n------------------------------------------------");
																			for(int i=0; i<LIBRARY_CAPACITY; ++i)
																			{
																				if(memberNameArray[i] == null)
																					continue;
																				if(memberNameArray[i].equalsIgnoreCase(searchName))
																					System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																			}
																		}
																			System.out.printf("%n");
																	}
																	// end of sesrch by full name
																	break;
																	
																	// sesrch by a part of the name
																	case 2:
																	{
																		System.out.printf("Part of the Name: ");
																		String searchPartOfTheName = input.next();
																
																		//checks if there is occurrances of name of search case. if so, counts.						
																		int counter=0;
																		for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		{
																			if(memberNameArray[i] == null)
																				continue;
																
																			if(memberNameArray[i].toLowerCase().contains(searchPartOfTheName.toLowerCase()))
																				++counter;
																		}//end of counting age occurrances
															
																		//displays the occurances of age of search case found						
																		if(counter == 0)
																			System.out.printf("%nNothing found.%n");
																		else
																		{
																			System.out.printf("%nID   Name          Family name   Gender   Age   ");
																			System.out.printf("%n------------------------------------------------");
																			for(int i=0; i<LIBRARY_CAPACITY; ++i)
																			{
																				if(memberNameArray[i] == null)
																				continue;
																	
																				if(memberNameArray[i].toLowerCase().contains(searchPartOfTheName.toLowerCase()))
																					System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																			}
																		}
																			System.out.printf("%n");
																	}
																	// end of sesrch by a part of the name
																	
																	//back to members menu
																	case 3:
																	{
																		continue searchLoop;
																	}
																	
																	//exit the program
																	case 4:
																	{
																		isProgramOpen = "closed";
																		continue programLoop;
																	}
																	
																}
																// end of switch(Integer.patseInt(subSearchName)), search by full nsme or a part of name
															}
															//end of case 2, search by name
															break;
															
															//search by family name
															case 3:
															{
																System.out.printf(
																					"%nIncluding"+
																					"%n1) the whole family name"+
																					"%n2) part of the family name"+
																					"%n3) Back to previous menu"+
																					"%n4) Exit the program"+
																					"%nPlease enter a number from 1 to 4: ");
																String subSearchFamilyName = input.next();
																
																while(!(subSearchFamilyName.equalsIgnoreCase("1") || subSearchFamilyName.equalsIgnoreCase("2") || subSearchFamilyName.equalsIgnoreCase("3") || subSearchFamilyName.equalsIgnoreCase("4")))
																{
																	System.out.printf(
																						"%nIncluding"+
																						"%n1) the whole family name"+
																						"%n2) part of the family name"+
																						"%n3) Back to previous menu"+
																						"%n4) Exit the program"+
																						"%nPlease enter a number from 1 to 4: ");
																	subSearchFamilyName = input.next();
																}
																
																switch(Integer.parseInt(subSearchFamilyName))
																{
																	//search by full family name
																	case 1:
																	{
																		System.out.printf("Family name: ");
																		String searchFamilyName = input.next();
																
																		//checks if there is occurrances of name of search case. if so, counts.						
																		int counter=0;
																		for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		{
																			if(memberFamilyNameArray[i] == null)
																			continue;
																		
																			if(memberFamilyNameArray[i].equalsIgnoreCase(searchFamilyName))
																				++counter;
																		}//end of counting age occurrances
															
																		//displays the occurances of age of search case found						
																		if(counter == 0)
																			System.out.printf("%nNothing found.%n");
																		else
																		{
																			System.out.printf("%nID   Name          Family name   Gender   Age   ");
																			System.out.printf("%n------------------------------------------------");
																			for(int i=0; i<LIBRARY_CAPACITY; ++i)
																			{
																				if(memberFamilyNameArray[i] == null)
																					continue; 
																				
																				if(memberFamilyNameArray[i].equalsIgnoreCase(searchFamilyName))
																					System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																			}
																					System.out.printf("%n");
																		}
																	}
																	//end of search by full family name
																	break;
																	
																	//search by part family name
																	case 2:
																	{
																		System.out.printf("Part of the family name: ");
																		String searchPartOfTheFamilyName = input.next();
																
																		//checks if there is occurrances of name of search case. if so, counts.						
																		int counter=0;
																		for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		{
																			if(memberFamilyNameArray[i] == null)
																			continue; 	
																
																			if(memberFamilyNameArray[i].toLowerCase().contains(searchPartOfTheFamilyName.toLowerCase()))
																				++counter;
																		}//end of counting age occurrances
															
																		//displays the occurances of age of search case found						
																		if(counter == 0)
																			System.out.printf("%nNothing found.%n");
																		else
																		{
																			System.out.printf("%nID   Name          Family name   Gender   Age   ");
																			System.out.printf("%n------------------------------------------------");
																			for(int i=0; i<LIBRARY_CAPACITY; ++i)
																			{
																				if(memberFamilyNameArray[i] == null)
																					continue;
																			
																				if(memberFamilyNameArray[i].toLowerCase().contains(searchPartOfTheFamilyName.toLowerCase()))
																					System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																			}
																			System.out.printf("%n");
																		}
																	}
																	//end of search by part family name
																	
																	//back to members menu
																	case 3:
																	{
																		continue searchLoop;
																	}
																	
																	//exit the program
																	case 4:
																	{
																		isProgramOpen = "closed";
																		continue programLoop;
																	}
																}
																// end of switch(Integer.parseInt(subSearchFamilyName)), search about full or part family name
															}
															//end of search by family name
															break;
															
															//search by gender
															case 4:
															{
																System.out.printf("Gender((M)male, (F)female): ");
																char searchGender = input.next().charAt(0);
																while(!(searchGender == 'M' || searchGender == 'm' || searchGender == 'F' || searchGender == 'f'))
																{
																	System.out.printf("Gender((M)male, (F)female): ");
																	searchGender = input.next().charAt(0);
																}
																
																//checks if there is occurrances of gender of search case. if so, counts.						
																int counter=0;
																for(int i=0; i<LIBRARY_CAPACITY; ++i)
																{
																	if(memberGenderArray[i] == Character.toUpperCase(searchGender))
																		++counter;
																}//end of counting gender occurrances
															
																//displays the occurances of gender of search case found						
																if(counter == 0)
																	System.out.printf("%nNothing found.%n");
																else
																{
																	System.out.printf("%nID   Name          Family name   Gender   Age   ");
																	System.out.printf("%n------------------------------------------------");
																	for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		if(memberGenderArray[i] == Character.toUpperCase(searchGender))
																			System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																	System.out.printf("%n");	
																}
															}
															//end of search by gender
															break;
															
															//search by age
															case 5:
															{
																System.out.printf("Age: ");
																int searchAge = input.nextInt();
																
																//checks if there is occurrances of age of search case. if so, counts.						
																int counter=0;
																for(int i=0; i<LIBRARY_CAPACITY; ++i)
																{
																	if(memberAgeArray[i] == searchAge)
																		++counter;
																}//end of counting age occurrances
															
																//displays the occurances of age of search case found						
																if(counter == 0)
																	System.out.printf("%nNothing found.%n");
																else
																{
																	System.out.printf("%nID   Name          Family name   Gender   Age   ");
																	System.out.printf("%n------------------------------------------------");
																	for(int i=0; i<LIBRARY_CAPACITY; ++i)
																		if(memberAgeArray[i] == searchAge)
																			System.out.printf("%n%-5s%-14s%-14s%-9c%-6d", i+1, memberNameArray[i], memberFamilyNameArray[i], memberGenderArray[i], memberAgeArray[i]);
																	System.out.printf("%n");
																}
															}
															//end of search by age
															break;
															
															//back to previous menu
															case 6:
															{
																continue membersAffairsLoop;
															}
															
															//serch by menu, option 7: exit program
															case 7:
															{
																isProgramOpen = "closed";
																continue programLoop;
															}
															
														}// end of dealing with user search choice
													}// end of searchLoop: while(Integer.parseInt(membersAffairs) == 1)
														
												}
												 //end of case 1, search about members
												break;
													 
												 //show member
												case 2:
												{
													// Your membership profile will be shown
													// Show ID is recieved to show profile
													System.out.printf("%nEnter ID: ");
													int showID = input. nextInt();

													//Validity of show ID is ckecked and the previous specification is shown
													if(isMembersListEmptyArray[showID-1] == true)
													{
														System.out.printf("%nName: %s", memberNameArray[showID-1]);
														System.out.printf("%nFamily name: %s", memberFamilyNameArray[showID-1]);
														System.out.printf("%nGender: %c", memberGenderArray[showID-1]);
														System.out.printf("%nAge: %d%n", memberAgeArray[showID-1]);
													}
													else
														System.out.printf("%nID not found.%n");
												}
												 // end of case 2, show member
												break;
												 
												 //edit member
												case 3:
												{
													// Edit ID is recieved to show profile
													System.out.printf("%nEnter ID: ");
													int editID = input.nextInt();
													

													//Validity of edit ID is ckecked and the previous specification is shown
													if(isMembersListEmptyArray[editID-1] == true)
													{
														System.out.printf("%nName: %s", memberNameArray[editID-1]);
														System.out.printf("%nFamily name: %s", memberFamilyNameArray[editID-1]);
														System.out.printf("%nGender: %c", memberGenderArray[editID-1]);
														System.out.printf("%nAge: %d", memberAgeArray[editID-1]);
														
														// New specification is recieved in order to be updated
														System.out.printf("%nNew Name: ");
														String memberNewName = input.next();
														memberNameArray[editID-1] = memberNewName.substring(0 ,1).toUpperCase() + memberNewName.substring(1);
														
														System.out.printf("%nNew family name: ");
														String memberNewFamilyName = input.next();
														memberFamilyNameArray[editID-1] = memberNewFamilyName.substring(0 ,1).toUpperCase() + memberNewFamilyName.substring(1);
																		
														System.out.printf("%nNew Gender((M)male, (F)female): ");
														char memberNewGender = input.next().charAt(0);
														while(!(memberNewGender == 'M' || memberNewGender == 'm' || memberNewGender == 'F' || memberNewGender == 'f'))
														{
															System.out.printf("%nNew Gender((M)male, (F)female): ");
															memberNewGender = input.next().charAt(0);
														}
														memberGenderArray[editID-1] = Character.toUpperCase(memberNewGender);
														
														
														System.out.printf("%nNew Age: ");
														memberAgeArray[editID-1] = input.nextInt();
														
														System.out.printf("%nThe memeber updated successfully.%n");
													}
													else
														System.out.printf("%nID not found.%n");
												}
												 // end od case 3, edit member
												break;
												 
												 //delete member
												case 4:
												{
													// delete your membership
						
													// Delete ID is recieved
													System.out.printf("%nEnter ID: ");
													int deleteID = input.nextInt();
													
													// Validity of delete is checked and member of that ID is deleted
													if(isMembersListEmptyArray[deleteID-1] == true)
													{
														System.out.printf("%nProfile of the member with ID %d: ", deleteID);
														System.out.printf("%nName = %s", memberNameArray[deleteID-1]);
														System.out.printf("%nFamily name = %s", memberFamilyNameArray[deleteID-1]);
														System.out.printf("%nGender = %c", memberGenderArray[deleteID-1]);
														System.out.printf("%nAge = %d", memberAgeArray[deleteID-1]);
														
														System.out.printf("%nAre you sure about deleting member with ID %d? ( Y(Yes), N(No))", deleteID);
														char confirmDeleteID = input.next().charAt(0);
														while(!(confirmDeleteID == 'Y' || confirmDeleteID == 'y' || confirmDeleteID == 'N' || confirmDeleteID == 'n'))
														{
															System.out.printf("%nAre you sure about deleting member with ID %d? ( Y(Yes), N(No) ) ", deleteID);
															confirmDeleteID = input.next().charAt(0);
														}
														
														if(confirmDeleteID == 'Y' || confirmDeleteID == 'y')
														{
															isMembersListEmptyArray[deleteID-1] = false;
															memberNameArray[deleteID-1] = null;
															memberFamilyNameArray[deleteID-1] = null;
															memberGenderArray[deleteID-1] = '\u0000';
															memberAgeArray[deleteID-1] = 0;
															System.out.printf("%nThe memeber deleted successfully.%n");
														}
														else
															System.out.printf("%nThe memeber was not deleted.%n");
														
													}
													else
														System.out.printf("%nID not found.%n");
												}
												 // end of case 4, dekete member
												 break;
												 
												 //back to previous menu
												case 5:
												{
													// to go back to first menu(
													continue programLoop;
												}
												//break;
												 
												 //exit the program
												case 6:
												{
													isProgramOpen = "closed";
													continue programLoop;
												}
											}
											// end of switch(Integer.parseInt(membersAffairs)): members affairs
										}
										//while(Integer.parseInt(firstMenu) == 2), first menu, option 2: member affairs 
									}
									// end of case2, option: member affairs
									break;
								
									//first menu, option 3: exit program
									case 3:
									{
										isProgramOpen = "closed";
									}
								}
								// end of switch(Integer.parseInt(firstMenu)), taking actions on the choice of user if he adds a member or handles previous members	
						}
						// end of programLoop, program is closed	
	}
	// end of method main
}
// end of class LibraryV2