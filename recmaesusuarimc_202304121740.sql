INSERT INTO dbmysqlartistas.recmaesusuarimc (rec_nroreg_remc,rec_nroreg_reus,rec_ntoken_reus,rec_tipfil_remc,rec_modulo_remc,sis_codpai_sipa,sis_idedpt_sidp,sis_codpro_sipr,rec_geodis_remc,rec_geolat_reus,rec_geolon_reus,rec_genmus_reus,rec_fecagi_remc,rec_fecagf_remc,rec_diapun_remc,rec_keyfil_remc,rec_keytmp_remc,rec_keytm1_remc,rec_keytm2_remc,rec_keytm3_remc,rec_keytm4_remc,rec_erraux_remc,rec_estreg_remc) VALUES
	 ('205020000001','205020000001','5050','1','M02','205','205020','205020001000',20,10.466381,-73.26087,'1000 1001','2020-02-25','2021-11-30','mad17 man17 tar17 noc17','+activo >1000 >1001','NA','NA','NA','NA','NA','SELECT MATCH(artist.apj_keyloc_aphp) AGAINST (*1x1*>cantante* >valledupar**1x1* IN BOOLEAN MODE) AS relevancia,
						 MATCH(artist.apj_keyest_aphp) AGAINST (*1x1*+activo >1000 >1001*1x1* IN BOOLEAN MODE) AS estados FROM apjmaeshomepama as artist  WHERE  artist.sis_codpai_sipa = *1x1*205*1x1* AND artist.apj_keyraf_aphp >= 190812 AND artist.apj_keyrai_aphp <= 190817 AND MATCH(artist.apj_keyloc_aphp) AGAINST (*1x1*>cantante* >valledupar**1x1* IN BOOLEAN MODE) AND 
							   MATCH(artist.apj_keyest_aphp) AGAINST (*1x1*+activo >1000 >1001*1x1* IN BOOLEAN MODE) HAVING relevancia > 1 AND estados > 1
SELECT json_object(
						   *1x1*apj_nroreg_aphp*1x1*,artist.apj_nroreg_aphp,
						   *1x1*apj_titgru_aphp*1x1*,artist.apj_titgru_aphp,
						   *1x1*apj_lnkgru_aphp*1x1*,artist.apj_lnkgru_aphp,
						   *1x1*apj_exlema_aphp*1x1*,artist.apj_exlema_aphp,
						   *1x1*apj_tipart_aphp*1x1*,artist.apj_tipart_aphp,
						   *1x1*rec_nroreg_reus*1x1*,artist.rec_nroreg_reus,
						   *1x1*apj_valtra_aphp*1x1*,artist.apj_valtra_aphp,
						   *1x1*apj_valcal_aphp*1x1*,artist.apj_valcal_aphp,
						   *1x1*apj_valpun_aphp*1x1*,artist.apj_valpun_aphp,
						   *1x1*apj_valpop_aphp*1x1*,artist.apj_valpop_aphp,
						   *1x1*apj_totseg_aphp*1x1*,artist.apj_totseg_aphp,
						   *1x1*apj_estaut_aphp*1x1*,artist.apj_estaut_aphp,
						   *1x1*apj_estges_aphp*1x1*,artist.apj_estges_aphp,
						   *1x1*apj_estdis_aphp*1x1*,artist.apj_estdis_aphp,
						   *1x1*apj_estloc_aphp*1x1*,artist.apj_estloc_aphp,
						   *1x1*apj_estpen_aphp*1x1*,artist.apj_estpen_aphp,
						   *1x1*apj_peifec_aphp*1x1*,artist.apj_peifec_aphp,
						   *1x1*apj_peihor_aphp*1x1*,artist.apj_peihor_aphp,
						   *1x1*apj_peikey_aphp*1x1*,artist.apj_peikey_aphp,
						   *1x1*apj_peffec_aphp*1x1*,artist.apj_peffec_aphp,
						   *1x1*apj_pefhor_aphp*1x1*,artist.apj_pefhor_aphp,
						   *1x1*apj_pefkey_aphp*1x1*,artist.apj_pefkey_aphp,
						   *1x1*sis_nombre_sipr*1x1*,ciudad.sis_nombre_sipr,
						   *1x1*sis_nombre_sidp*1x1*,estado.sis_nombre_sidp,
						   *1x1*apj_estreg_aphp*1x1*,artist.apj_estreg_aphp,*1x1*apj_recurs_imge*1x1*,(SELECT CAST(CONCAT(*1x1*[*1x1*,GROUP_CONCAT(JSON_OBJECT(
											*1x1*rec_nroreg_regl*1x1*,recursos.rec_nroreg_regl,
											*1x1*rec_observ_regl*1x1*,recursos.rec_observ_regl,
											*1x1*rec_grprec_regr*1x1*,recursos.rec_grprec_regr,
											*1x1*rec_tiprec_regl*1x1*,recursos.rec_tiprec_regl,
											*1x1*rec_nomrec_regl*1x1*,recursos.rec_nomrec_regl
											)),*1x1*]*1x1*) AS JSON)
							FROM recgaleriarecma as recursos
								 WHERE recursos.apj_nroreg_aphp = artist.apj_nroreg_aphp AND
									    (recursos.rec_grprec_regr = *1x1*101*1x1* OR recursos.rec_grprec_regr = *1x1*103*1x1* ) AND 
									   recursos.rec_estreg_regl =*1x1*1*1x1*
								 ORDER BY recursos.rec_rllave_regl DESC)) as ListArtist,MATCH(artist.apj_keyloc_aphp) AGAINST (*1x1*>cantante* >valledupar**1x1* IN BOOLEAN MODE) AS relevancia,
						 MATCH(artist.apj_keyest_aphp) AGAINST (*1x1*+activo >1000 >1001*1x1* IN BOOLEAN MODE) AS estados,(6371 * ACOS(SIN(RADIANS(artist.apj_geolat_aphp)) * SIN(RADIANS(10.4663810730))
				 + COS(RADIANS(artist.apj_geolon_aphp - -73.2608718872)) * COS(RADIANS(artist.apj_geolat_aphp))
				 * COS(RADIANS(10.4663810730)))) AS distance FROM apjmaeshomepama as artist
						   INNER JOIN sispaisciudadmd AS ciudad ON (artist.sis_codpro_sipr = ciudad.sis_codpro_sipr)
						   INNER JOIN sispaisbestados AS estado ON (artist.sis_idedpt_sidp = estado.sis_idedpt_sidp) WHERE  artist.sis_codpai_sipa = *1x1*205*1x1* AND artist.apj_keyraf_aphp >= 190812 AND artist.apj_keyrai_aphp <= 190817 AND MATCH(artist.apj_keyloc_aphp) AGAINST (*1x1*>cantante* >valledupar**1x1* IN BOOLEAN MODE) AND 
							   MATCH(artist.apj_keyest_aphp) AGAINST (*1x1*+activo >1000 >1001*1x1* IN BOOLEAN MODE) HAVING relevancia > 1 AND estados > 1 ORDER BY relevancia DESC  LIMIT 2,2','1');
