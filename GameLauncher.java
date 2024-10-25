	public  void Start (){
		// Responsável pela extração de arquivos
		if (null == m_extractPatchResourceFunc) {
			m_extractPatchResourceFunc = new ExtractPatchResourceFunc(this, CONST_RESULT_CODE_REQUEST_EXTRACT_PATCH_RESOURCE);
			Bundle bundle = new Bundle();
			bundle.putString("path", V.edt_path.getText().toString());
			m_extractPatchResourceFunc.Start(bundle);
		}
		// Responsável por selecionar o jogo para QUAKE1 ao executar o apk
		ChangeGame(Q3EGlobals.GAME_QUAKE1);
		System.out.printf("Jogo trocado para QUAKE 1");

		// Reponsável por executar o jogo imediatamente
		if (null == m_startGameFunc)
			m_startGameFunc = new StartGameFunc(this, CONST_RESULT_CODE_REQUEST_EXTERNAL_STORAGE_FOR_START);
		Bundle bundle = new Bundle();
		bundle.putString("path", V.edt_path.getText().toString());
		m_startGameFunc.Start(bundle);
	}
